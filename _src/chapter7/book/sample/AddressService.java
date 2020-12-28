package book.sample;

public class AddressService {
    public Address getAddress(String name) {
        Address address = new Address();
        address.setStreet("Street");
        address.setNumber("Number 15");
        return address;
    }
}
