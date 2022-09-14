package com.mypack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mypack.entity.Notes;

@Repository
public interface NotesRepo extends JpaRepository<Notes, Long>{

	List<Notes> findByFromEmployeeIdAndIsReply(String fromEmployeeId, boolean isReply);
	List<Notes> findByFromIdAndIsReply(Long fromId, boolean isReply);
	
	List<Notes> findByToEmployeeIdAndIsReply(String toEmployeeId,boolean isReply);
	List<Notes> findByToIdAndIsReply(Long toId,boolean isReply);
	
	@Query("select count(n) from Notes n where n.toEmployeeId = ?1 and n.isReply=false and reply= null")
	long getNotesCountByEmployeeId(String toEmployeeId);
	
	@Query("select count(n) from Notes n where n.toId = ?1 and n.isReply=false and reply = null")
	long getNotesCountById(Long toId);
}
