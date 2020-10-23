package com.example.crm;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.crm.dto.AddCustomerRequest;
import com.example.crm.dto.AddCustomerResponse;
import com.example.crm.entity.Address;
import com.example.crm.entity.AddressType;
import com.example.crm.service.CrmService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes=CrmMicroserviceApplication.class)
@AutoConfigureMockMvc
// CUT: CrmController
class CrmControllerTest {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
    @MockBean
    private CrmService crmService;
    
	// MUT: Method Under Test -> CromController::addCustomer
	@Test
	void addCustomer_then_success() throws Throwable {
		// 1. Test Setup/Fixture
		AddCustomerRequest request = new AddCustomerRequest();
		request.setIdentity("45533659684");
		request.setFullname("jack bauer");
		request.setEmail("jack.bauer@example.com");
		request.setSms("555555");
		request.setPhoto("");
		Address home = new Address();
		home.setId(1L);
		home.setCity("istanbul");
		home.setCountry("turkey");
		home.setLine("address one");
		home.setType(AddressType.HOME);
		home.setZipCode("34212");
		Address business = new Address();
		business.setId(1L);
		business.setCity("istanbul");
		business.setCountry("turkey");
		business.setLine("address two");
		business.setType(AddressType.BUSINESS);
		business.setZipCode("34216");
		request.setAddresses(new ArrayList<>(List.of(home,business)));
		AddCustomerResponse response = new AddCustomerResponse("ok");
		Mockito.when(crmService.create(request)).thenReturn(response);
		// 2. Calling exercise method 
		mvc.perform(
			MockMvcRequestBuilders.post("/customers")
			                      .content(mapper.writeValueAsString(request))
			                      .contentType(MediaType.APPLICATION_JSON_VALUE)
			                      .accept(MediaType.APPLICATION_JSON_VALUE)
		)// 3. Verification
		.andExpect(status().isOk())
		.andExpect(jsonPath("status",is("ok")));
		// 4. Tear-down
	}

}
