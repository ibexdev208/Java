package app.mysql;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import app.mysql.dao.MonitorDao;
import app.mysql.entity.Monitor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MonitorDaoTest {

	@Autowired
	private MonitorDao monitorDao;

	
	@Test
	@DisplayName("Gets all monitors")
	public void listMonitorsTest() {
		List<Monitor> monitors = (List<Monitor>) monitorDao.findAll();
		assertThat(monitors).size().isGreaterThan(0);
	}

	@Test
	@Rollback(true)
	@DisplayName("Edits a monitor")
	public void updateMonitorTest() {
		Monitor monitor = monitorDao.findById(6).get();
		monitor.setPrice(800);

		monitorDao.save(monitor);

		Monitor updatedMonitor = monitorDao.findById(6).get();

		assertThat(updatedMonitor.getPrice()).isEqualTo(800);
	}

	@Test
	@Rollback(true)
	@DisplayName("Adds a new monitor")
	public void testCreateProduct() {
		Monitor savedProduct = monitorDao.save(new Monitor(null, "Test", 1280, "MA2721c", (float) 999.49));
		assertThat(savedProduct.getId()).isGreaterThan(0);
		}

	@Test
	@Rollback(true)
	@DisplayName("Deletes a monitor")
	public void deleteMonitorTest() {
		//Finds the item then delete it
		Monitor monitor = monitorDao.findById(9).get();
		monitorDao.deleteById(monitor.getId());

		//Check if the item has been deleted by asserting that it returns null
		Monitor hasItBeenDeleted = monitorDao.findById(9).get();
		assertThat(hasItBeenDeleted).isNull();

	}
}
