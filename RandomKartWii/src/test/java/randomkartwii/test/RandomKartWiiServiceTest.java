package randomkartwii.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import randomkartwii.service.RandomKartWiiService;

public class RandomKartWiiServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		RandomKartWiiService service = new RandomKartWiiService();
		
		service.generateChoices(3, 4, "1,2,3");
	}

}
