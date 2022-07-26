package br.com.encurtathor.encurtador.controller;


import br.com.encurtathor.encurtador.Util.UserCreator;
import br.com.encurtathor.encurtador.Util.UserPostBodyCreator;
import br.com.encurtathor.encurtador.dto.CustomerPostBody;
import br.com.encurtathor.encurtador.entity.Customer;
import br.com.encurtathor.encurtador.service.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CustomerControllerTest {
    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerServiceMock;

    @BeforeEach
    void setUp() {
        BDDMockito.when(customerServiceMock.findByIdOrThrowBadRequestException(ArgumentMatchers.anyLong()))
                .thenReturn(UserCreator.createValidUser());

        BDDMockito.when(customerServiceMock.createUser(ArgumentMatchers.any(CustomerPostBody.class)))
                .thenReturn(UserCreator.createValidUser());
    }

    @Test
    @DisplayName("Find by id and return user when successful")
    void findById_ReturnUser_WhenSuccessful() {
        Long expectedId = UserCreator.createValidUser().getId();

        Customer customer = customerController.findById(1L).getBody();

        Assertions.assertThat(customer).isNotNull();
        Assertions.assertThat(customer.getId()).isNotNull().isEqualTo(expectedId);
    }

    @Test
    @DisplayName("create Customer when Successful")
    void save_ReturnsUser_WhenSuccessful() {
        Customer customer = customerController.createUser(UserPostBodyCreator.createUserPostBody()).getBody();

        Assertions.assertThat(customer).isNotNull().isEqualTo(UserCreator.createValidUser());
    }
}