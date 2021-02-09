package app_mysql_service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app_mysql_Entity.Monitor;
import app_mysql_dao.MonitorDao;

@Service
public class MonitorServiceImp implements MonitorService {


	@Autowired
	private MonitorDao monitorDao;
	
	@Override
	public List<Monitor> getMonitors() {
		return monitorDao.findAll();
	}
	
	@Override
	public Optional<Monitor> getMonitor(Long id) {
		return monitorDao.findById(id);
	}

	@Override
	public Monitor addMonitor(Monitor office) {
		return monitorDao.save(office);
	}

	@Override
	public Monitor editMonitor(Monitor office) {
		return monitorDao.save(office);
	}

	@Override
	public void deleteMonitor(Long id) {
		monitorDao.deleteById(id);
	}

	@Override
	public void deleteMonitors() {
		monitorDao.deleteAll();
		
	}
}
