package com.alldata.JavaCourse2025.model;/*
 * @created 02/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
