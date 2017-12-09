package br.com.codexbookstore.control.viewHelpers.customer;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.Phone;
import br.com.codexbookstore.domain.User;
import br.com.codexbookstore.domain.customer.CreditCard;
import br.com.codexbookstore.domain.customer.Customer;
import br.com.codexbookstore.domain.customer.Gender;
import br.com.codexbookstore.domain.location.Address;
import br.com.codexbookstore.domain.location.Country;
import br.com.codexbookstore.domain.location.State;
import br.com.codexbookstore.utils.SecurePassword;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateCustomerVh implements IViewHelper {
    @Override
    public Entity getEntity(HttpServletRequest request) {
        Customer customer = new Customer();
        Phone phone = new Phone();
        Address address = new Address();
        CreditCard creditCard = new CreditCard();
        User user = new User();
        DateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dob;
        Gender gender = request.getParameter("gender").equals("MALE") ? Gender.MALE : Gender.FEMALE;

        // get request params and set object properties
        try {
            // personal info
            dob = dtFormat.parse(request.getParameter("dob"));
            customer.setDob(dob);
            customer.setName(request.getParameter("name"));
            customer.setIdentificationDoc(request.getParameter("registry"));
            customer.setGender(gender);

            // contact info
            phone.setAreaCode(request.getParameter("area-code"));
            phone.setNumber(request.getParameter("phone-number"));
            customer.setPhone(phone);

            // address
            address.setPostalCode(request.getParameter("postal-code"));
            address.setNumber(request.getParameter("number"));
            address.setDistrict(request.getParameter("district"));

            // credit card
            creditCard.setCardNumber(request.getParameter("card-number"));
            creditCard.setNamePrinted(request.getParameter("card-name"));
            creditCard.setSecurityCode(request.getParameter("security-code"));

            StringBuilder cardExpiration = new StringBuilder(request.getParameter("expire-month"));
            cardExpiration.append("/");
            cardExpiration.append(request.getParameter("expire-year"));
            creditCard.setExpirationDate(cardExpiration.toString());

            customer.addCreditCard(creditCard);

            // authentication
            String passwd = SecurePassword.hashPassword(request.getParameter("password"));
            String confirmPasswd = SecurePassword.hashPassword(request.getParameter("pwd-confirm"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(passwd);

            customer.setUser(user);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        // return the object
        return customer;
    }

    @Override
    public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {

    }
}
