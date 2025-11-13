package com.nit.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Person;
import com.nit.entity.PhoneNumber;
import com.nit.repository.IPersonRepository;
import com.nit.repository.IPhoneNumberRepository;

@Service("OTMService")
public class OTMAssociationMappingServiceImpl implements IOTOMAssociationMgmtService {

	@Autowired
    private IPersonRepository personRepo;

    @Autowired
    private IPhoneNumberRepository phoneRepo;
	
	@Override
	public void saveDataUsingParent() {
		
		//create parent
		Person per = new Person("Raja", "Hyderabad");
		
		//create clild objects
		PhoneNumber ph1 = new PhoneNumber(7894561231L, "Airtel", "Personal");
		PhoneNumber ph2 = new PhoneNumber(7038898336L, "Jio", "Office");
		
		//Link parent to child
		ph1.setPersonInfo(per);
		ph2.setPersonInfo(per);
		
		//Add children to parent's set
		Set<PhoneNumber> phoneSet = new HashSet<>();
		phoneSet.add(ph1);
		phoneSet.add(ph2);
		per.setContactDetails(phoneSet);
		
		//Save parent (cascade will save children)
		personRepo.save(per);
		System.out.println("Person and associated PhoneNumber save (Parent -> Child)");
		
	}

	// ---------------- SAVE DATA USING CHILD ----------------
    @Override
    public void saveDataUsingChild() {
        // Create parent
        Person per = new Person("Ramesh", "Vizag");

        // Create child objects
        PhoneNumber ph1 = new PhoneNumber(88888888L, "Airtel", "Personal");
        PhoneNumber ph2 = new PhoneNumber(77777777L, "VI", "Office");

        // Link parent to child
        ph1.setPersonInfo(per);
        ph2.setPersonInfo(per);

        // Add children to parent's set
        Set<PhoneNumber> phonesSet = new HashSet<>();
        phonesSet.add(ph1);
        phonesSet.add(ph2);
        per.setContactDetails(phonesSet);

        // Save children (cascade will save parent automatically)
        phoneRepo.save(ph1);
        phoneRepo.save(ph2);
        System.out.println("Person and associated PhoneNumbers saved (Child → Parent).");
    }

    // ---------------- LOAD DATA USING PARENT ----------------
    @Override
    public void loadDataUsingParent() {
        Iterable<Person> it = personRepo.findAll();
        it.forEach(per -> {
            System.out.println("Parent: " + per);
            // Uncomment below to see child data based on FetchType
            /*
            Set<PhoneNumber> childs = per.getContactDetails();
            System.out.println("Child count: " + childs.size());
            childs.forEach(ph -> System.out.println("Child: " + ph));
            */
        });
        
        
        // NOTE:
        // If FetchType.LAZY → Only parent data loads (single SELECT)
        // If FetchType.EAGER → Both parent and child data load together
    }

}
