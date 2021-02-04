package app_mysql_dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app_mysql_Entity.Monitor;

@Repository
public interface MonitorDao extends JpaRepository<Monitor, Long> {

}
