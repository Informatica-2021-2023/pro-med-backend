package gov.edu.ce.anm.promed.services;

import gov.edu.ce.anm.promed.domain.model.Address;
import gov.edu.ce.anm.promed.repositories.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Transactional
    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    @Transactional
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Transactional
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    @Transactional
    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }
}
