package com.sample;

import com.sample.core.domain.Address;
import com.sample.core.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
@ComponentScan({"com.oauth", "com.sample"})
public class Application {

    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        Application mainObj = context.getBean(Application.class);
        mainObj.init();

    }

    public void init() {
        Address address = new Address();
        address.setName("Sector 144");
        address.setLatitude(28.491605);
        address.setLongitude(77.433014);
        addressRepository.save(address);

        Address address0 = new Address();
        address0.setName("Sector 142");
        address0.setLatitude(28.499752);
        address0.setLongitude(77.413616);
        addressRepository.save(address0);

        Address address01 = new Address();
        address01.setName("Sector 143");
        address01.setLatitude(28.500959);
        address01.setLongitude(77.425976);
        addressRepository.save(address01);

        Address address1 = new Address();
        address1.setName("Sector 143 A");
        address1.setLatitude(28.499073);
        address1.setLongitude(77.429667);
        addressRepository.save(address1);

        Address address2 = new Address();
        address2.setName("Sector 143 B");
        address2.setLatitude(28.495301);
        address2.setLongitude(77.425632);
        addressRepository.save(address2);

        Address address3 = new Address();
        address3.setName("Sector 166");
        address3.setLatitude(28.486777);
        address3.setLongitude(77.425718);
        addressRepository.save(address3);

        Address address4 = new Address();
        address4.setName("Sector 167");
        address4.setLatitude(28.490096);
        address4.setLongitude(77.415419);
        addressRepository.save(address4);

        Address address5 = new Address();
        address5.setName("Sector 168");
        address5.setLatitude(28.493566);
        address5.setLongitude(77.408209);
        addressRepository.save(address5);
    }
}
