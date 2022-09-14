package com.mypack.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.mypack.dto.ChangeAppointmentStatusDto;
import com.mypack.dto.SchedularDto;
import com.mypack.entity.Appointment;
import com.mypack.entity.PhysicianSchedule;
import com.mypack.repo.AppointmentRepo;
import com.mypack.repo.PhysicianScheduleRepo;
import com.mypack.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PhysicianScheduleService {

	@Autowired
	PhysicianScheduleRepo scheduleRepo;
	
	@Autowired
	AppointmentRepo appointmentRepo;

	private final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	public SchedularDto saveSchedule(SchedularDto request) {
		log.debug("PhysicianScheduleService >> saveSchedule start");
		PhysicianSchedule schedule = mapDtoToEntity(request);
		String startTime = formatDateToString(timeConversion("ADD", parseDate(request.getStartTime())));
		String endTime = formatDateToString(timeConversion("ADD", parseDate(request.getEndTime())));
		schedule.setStartTime(startTime);
		schedule.setEndTime(endTime);
		PhysicianSchedule scheduleDb = scheduleRepo.save(schedule);
		log.debug("PhysicianScheduleService >> saveSchedule exit");
		return mapEntityToDto(scheduleDb);
	}

	// Parse the string into date and return the date
	private Date parseDate(String value) {
		log.debug("PhysicianScheduleService >> parseDate start");
		Date result = null;
		try {
			result = DATE_FORMAT.parse(value);
		} catch (ParseException ex) {
			// just return null
		}
		return result;
	}

	private String formatDateToString(Date date) {
		return DATE_FORMAT.format(date);
	}

	private PhysicianSchedule mapDtoToEntity(SchedularDto request) {
		log.debug("PhysicianScheduleService >> mapDtoToEntity start");
		PhysicianSchedule entity = new PhysicianSchedule();
		if (!ObjectUtils.isEmpty(request.getId())) {
			entity.setId(request.getId());
		}
		entity.setDoctorId(request.getEmpDbId());
		entity.setEmployeeId(request.getEmployeeId());
		entity.setStartTime(request.getStartTime());
		entity.setEndTime(request.getEndTime());
		entity.setSubject(request.getSubject());
		entity.setDescription(request.getDescription());
		log.debug("PhysicianScheduleService >> mapDtoToEntity end");
		return entity;
	}

	private SchedularDto mapEntityToDto(PhysicianSchedule entity) {
		log.debug("PhysicianScheduleService >> mapEntityToDto");
		return new SchedularDto(entity.getId(), entity.getSubject(), entity.getStartTime(), entity.getEndTime(),
				entity.getDescription(), false, null, null);
	}

	public List<SchedularDto> getAllEventsByEmployeeId(String employeeId) {
		log.debug("PhysicianScheduleService >> getAllEventsByEmployeeId start");
		List<PhysicianSchedule> eventList = scheduleRepo.findByEmployeeId(employeeId);
		if (!CollectionUtils.isEmpty(eventList)) {
			return eventList.stream().map((event) -> {
				event.setStartTime(formatDateToString(timeConversion("MINUS", parseDate(event.getStartTime()))));
				event.setEndTime(formatDateToString(timeConversion("MINUS", parseDate(event.getEndTime()))));
				return mapEntityToDto(event);
			}).collect(Collectors.toList());
		}
		log.debug("PhysicianScheduleService >> getAllEventsByEmployeeId end");
		return new ArrayList<>();
	}

	public void deleteById(Long id) {
		scheduleRepo.deleteById(id);
	}
	
	public Date timeConversion(String operation, Date date){
		log.info("PhysicianScheduleService >> timeConversion start");
		if("ADD".equalsIgnoreCase(operation)) {
			LocalDateTime ld1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
					.plus(Duration.of(330, ChronoUnit.MINUTES));
			log.info("PhysicianScheduleService >> timeConversion end");
			return  Date.from(ld1.atZone(ZoneId.systemDefault()).toInstant());
		}else {
			LocalDateTime ld1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
					.minus(Duration.of(330, ChronoUnit.MINUTES));
			log.info("PhysicianScheduleService >> timeConversion end");
			return  Date.from(ld1.atZone(ZoneId.systemDefault()).toInstant());
		}
		
	}
	
	public void sendAppointmentRequest(Appointment appointment) {
		Date date = timeConversion("ADD", parseDate(appointment.getStartTime()));
		appointment.setStartTime(formatDateToString(date));
		appointment.setStatus(Constant.APPOINEMENT_PENDING);
		appointmentRepo.save(appointment);
		
	}
	
	public List<Appointment> getAllAppointmentsBasedOnStatusAndUserid(String status, String userId){
		log.info("PhysicianScheduleService >> getAllAppointmentsBasedOnStatusAndUserid start");
		if(userId.startsWith("PT")) {
			if("ALL".equalsIgnoreCase(status)) {
				return appointmentRepo.findByPatientId(userId);
			}
		return appointmentRepo.getAllPatientAppointment(status, userId);
		}
		if(userId.startsWith("DR")) {
			if("ALL".equalsIgnoreCase(status)) {
				return appointmentRepo.findByDoctorId(userId);
			}
			return appointmentRepo.getAllAppointmentRequestForPhysician(status, userId);
		}
		log.info("PhysicianScheduleService >> getAllAppointmentsBasedOnStatusAndUserid end");
		return new ArrayList<>();
	}
	
	@Transactional
	public void changeStatus(ChangeAppointmentStatusDto dto) {
		log.info("PhysicianScheduleService >> changeStatus start");
		appointmentRepo.changeStatus(dto.getStatus().toUpperCase(), dto.getId());
	}
}
