public class Main {
    public static void main(String[] args) {
        ShippingCompany company = new ShippingCompany("RELIABLE-MOVING");

        GroundTransportation groundTransportation = new GroundTransportation("123ABC");
        AirTransportation airTransportation1 = new AirTransportation("Aircraft 1", 2);
        AirTransportation airTransportation2 = new AirTransportation("Aircraft 2", 3);
        Lorry lorry = new Lorry("123ABC", 10, 1);
        Van van = new Van("456DEF", 20);

        company.add(groundTransportation);
        company.add(airTransportation1);
        company.add(airTransportation2);
        company.add(lorry);
        company.add(van);

        System.out.println("Transportes criados na empresa " + company.getName() + ":");
        for (Transport transport : company) {
            System.out.println(transport.toString());
        }

        company.makeTransportation(groundTransportation.getId(), "Origem", "Destino", 100.0);
        System.out.println("\nApós realizar um transporte:");
        System.out.println(company.toString());

        company.finalizeTransportation(groundTransportation.getId());
        System.out.println("\nApós finalizar um transporte:");
        System.out.println(company.toString());
    }
}