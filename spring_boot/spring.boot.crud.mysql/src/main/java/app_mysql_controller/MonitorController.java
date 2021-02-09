package app_mysql_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app_mysql_Entity.Monitor;
import app_mysql_dao.MonitorDao;

@RestController
//@RequestMapping(path="/monitor")
public class MonitorController {
	
//	@Autowired
//	private MonitorService monitorService;
	
	@Autowired
	private MonitorDao monitorDao;

	@GetMapping("/all")
	public List<Monitor> getMonitors() {

		return monitorDao.findAll();
		
	}

//	@GetMapping("/{id}")
//	public Option<Monitor> listMonitor(@RequestParam Long id) {
//
//		return (Option<>)monitorServiceImp.getMonitor(id);
//	}

//	@PostMapping("/add")
//	public Monitor newMonitor(@RequestBody Monitor monitor) {
//
//		return monitorServiceImp.addMonitor(monitor);
//	}
//
//	@PutMapping("/edit")
//	public Monitor updateMonitor(@RequestBody Monitor monitor) {
//
//		return monitorServiceImp.editMonitor(monitor);
//	}
//
//	@DeleteMapping("/delet/{id}")
//	public void removeMonitor(@RequestParam Long id) {
//		
//		monitorServiceImp.deleteMonitor(id);
//	}
}
