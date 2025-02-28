package com.example.files.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.files.model.MyFiles;

public interface FileRepo extends JpaRepository<MyFiles, Long>{

	Optional<MyFiles> findByFileName(String fileName);
	

}
