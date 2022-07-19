package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//import com.otp.hibernate.pojo.HibernateUtility;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
    List<AddressBook> findByCity(String city);
    List<AddressBook> findByState(String state);
    List<AddressBook> findAllByOrderByCity();
    List<AddressBook> findAllByOrderByState();
//    SessionFactory factory = HibernateUtility.getSessionFactory();
//    Session session = factory.openSession();
//    public static void updateAddressBookData(int id, AddressBookDTO addressBookDTO){
//        Query query = session.createQuery("from address_book where id = :id ");
//
//    }
}
