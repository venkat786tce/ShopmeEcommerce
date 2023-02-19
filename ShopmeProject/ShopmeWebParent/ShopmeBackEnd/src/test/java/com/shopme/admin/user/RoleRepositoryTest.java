package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.admin.users.RoleRepository;
import com.shopme.common.entity.Roles;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {

	@Autowired
	RoleRepository repo;
	
	@Test
	public void testFristRole() {
		Roles roleAdmin=new Roles("ADMIN", "Manage Everything");		
		Roles saveRole=repo.save(roleAdmin);		
		assertThat(saveRole.getId()).isGreaterThan(0);
	}
	
	@Test
	public void createRestRols() {

		Roles roleSalesPerson = new Roles("Salespersion",
				"Manage prodct price, customers, shipping, orders and sales report");

		Roles roleEditor = new Roles("Editor", "Manage categories, brands, product, articles and menus");

		Roles roleShipper = new Roles("Shipper", "view products, view orders and update order status");

		Roles roleAssistant = new Roles("Assistant", "Manage questions and reviews");

		repo.saveAll(List.of(roleSalesPerson, roleEditor, roleShipper, roleAssistant));

	}
	
}
