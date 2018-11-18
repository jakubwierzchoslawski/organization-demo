package jw.workshop.spring.organizationservice.model.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.UUID;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jw.workshop.spring.organizationservice.OrganizationServiceApplication;
import jw.workshop.spring.organizationservice.domain.model.OrganizationRepository;
import jw.workshop.spring.organizationservice.domain.model.jpa.OrganizationEntity;
import jw.workshop.spring.organizationservice.domain.model.jpa.OrganizationItemEntity;
import jw.workshop.spring.organizationservice.domain.model.jpa.OrganizationType;
import lombok.Data;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrganizationServiceApplication.class)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Data
public class OrganizationRepositoryTest {
	
	@Autowired
	private OrganizationRepository orgRepo;

	private OrganizationEntity org1 ;
	private OrganizationItemEntity orgItem1;
	private OrganizationItemEntity orgItem2;
	
	private Long orgID;
	
	
	
	@Before
	public void initializeData() {
	    org1 = new OrganizationEntity();
	    org1.setExternalId(Math.abs(new Random().nextLong()));
	    org1.setName(UUID.randomUUID()+"");
	    
	    orgItem1 = new OrganizationItemEntity();
	    orgItem2 = new OrganizationItemEntity();
	    
	    orgItem1.setCustomerID(Math.abs(new Random().nextLong()));
	    orgItem1.setType(OrganizationType.BRANCH);
	    
	    orgItem2.setCustomerID(Math.abs(new Random().nextLong()));
	    orgItem2.setType(OrganizationType.BRANCH);
	}
	
	@Test
	//@Rollback(false)
	public void test1_addOrganization(){

	    OrganizationEntity savedToDB = orgRepo.store(org1);
	    orgID = savedToDB.getID();
	    OrganizationEntity fromDB = orgRepo.find(savedToDB.getID());
	    
	    assertTrue(savedToDB.getExternalId().equals(fromDB.getExternalId()));
	}

	
	@Test
	//@Rollback(false)
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void test2_addItemsToOrganizationTest(){
		
	    OrganizationEntity orgEntity = orgRepo.store(org1);
	    //orgEntity.setOrganizationItems(new HashSet<>());
		
		orgEntity.getOrganizationItems().add(orgItem1);
		orgEntity.getOrganizationItems().add(orgItem2);
		orgEntity = orgRepo.store(orgEntity);
		
		
		OrganizationEntity savedOrg = orgRepo.find(orgEntity.getID());
		
		assertNotNull(savedOrg.getOrganizationItems());
		assertEquals(2,savedOrg.getOrganizationItems().size());
	}
	
	
}
