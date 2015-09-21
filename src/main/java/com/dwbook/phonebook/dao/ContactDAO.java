package com.dwbook.phonebook.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.dwbook.phonebook.dao.mappers.ContactMapper;
import com.dwbook.phonebook.representations.Contact;

public interface ContactDAO {
	@Mapper(ContactMapper.class)
	@SqlQuery("select * from contact where id = :id")
	Contact getcontactByid(@Bind("id") int id);
}
