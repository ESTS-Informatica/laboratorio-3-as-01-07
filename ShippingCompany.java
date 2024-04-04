import java.util.ArrayList;
import java.util.HashSet;

public class ShippingCompany extends HashSet<Transport> {
    private String name;
    private ArrayList<Transport> inService;

    public ShippingCompany(String name) {
        this.name = name;
        this.inService = new ArrayList<>();
    }

    private Transport getTransportation(String id) {
        for (Transport transport : this) {
            if (transport.getId().equals(id)) {
                return transport;
            }
        }
        return null;
    }

    public void makeTransportation(String id, String origin, String destination, double price) {
        Transport transport = getTransportation(id);
        if (transport != null && transport.isAvailable()) {
            transport.setOrigin(origin);
            transport.setDestination(destination);
            transport.setPrice(price);
            transport.setAvailable(false);
            inService.add(transport);
            this.remove(transport);
        }
    }

    public void finalizeTransportation(String id) {
        Transport transport = getTransportation(id);
        if (transport != null && !transport.isAvailable()) {
            transport.setOrigin("");
            transport.setDestination("");
            transport.setPrice(0.0);
            transport.setAvailable(true);
            inService.remove(transport);
            this.add(transport);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transportes em serviço da empresa ").append(name).append(":\n");
        for (Transport transport : inService) {
            sb.append(transport.toString()).append("\n");
        }
        return sb.toString();
    }
}