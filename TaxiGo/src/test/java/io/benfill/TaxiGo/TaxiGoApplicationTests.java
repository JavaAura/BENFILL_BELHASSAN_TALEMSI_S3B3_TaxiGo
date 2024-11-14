package io.benfill.TaxiGo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import springfox.documentation.spring.web.plugins.DocumentationPluginsBootstrapper;

@SpringBootTest
class TaxiGoApplicationTests {


	@MockBean
	private DocumentationPluginsBootstrapper documentationPluginsBootstrapper;

	@Test
	void contextLoads() {
	}

}
