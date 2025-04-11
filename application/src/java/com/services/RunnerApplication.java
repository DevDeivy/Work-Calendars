import java.util.Date;

public class RunnerApplication {
    public static void main(String[] args) throws Exception {
        int año = 2024;
        Date sundayFlowers = DatesServices.getstartSemanaSanta(año);
        System.out.println("domingo de ramos "  + sundayFlowers);

        Date sundayPascua = DatesServices.addDays(sundayFlowers, 7);
        System.out.println("pascua " + sundayPascua);

        Date epifania = DatesServices.NextMonday( new Date(año - 1900, 0, 6));
        System.out.println("reyes magos " + epifania);

        Date corpusChrist = DatesServices.NextMonday(DatesServices.addDays(sundayPascua, 61));
        System.out.println("corpus christi " + corpusChrist);


        Date jesushearth = DatesServices.NextMonday(DatesServices.addDays(sundayPascua, 68));
        System.out.println("corazon jesus " + jesushearth);
    }
}
