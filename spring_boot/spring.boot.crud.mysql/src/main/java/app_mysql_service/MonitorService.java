package app_mysql_service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app_mysql_Entity.Monitor;

@Service
public interface MonitorService {

	//Display all monitors
	List<Monitor> getMonitors();

	//Display one monitor
	Optional<Monitor> getMonitor(Long id);

	//Add an monitor
	Monitor addMonitor(Monitor monitor);

	//Edit an monitor
	Monitor editMonitor(Monitor monitor);

	//Delete an monitor
	void deleteMonitor(Long id);

	//Delete all monitor
	void deleteMonitors();
}
