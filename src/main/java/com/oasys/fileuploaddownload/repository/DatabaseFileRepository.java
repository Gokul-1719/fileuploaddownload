package com.oasys.fileuploaddownload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oasys.fileuploaddownload.model.DatabaseFile;



@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Integer> {

}
