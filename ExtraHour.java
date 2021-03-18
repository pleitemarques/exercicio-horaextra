import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.NumberFormat;

public class ExtraHour{

	public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);

        try {
        
            System.out.println("CALCULAR VALOR HORA EXTRA\n");
    
            System.out.println("CODIGO  |  DIA DA SEMANA");
            System.out.println("1       |  SEGUNDA-FEIRA");
            System.out.println("2       |  TERCA-FEIRA");
            System.out.println("3       |  QUARTA-FEIRA");
            System.out.println("4       |  QUINTA-FEIRA");
            System.out.println("5       |  SEXTA-FEIRA");
            System.out.println("6       |  SABADO-FEIRA");
            System.out.println("7       |  DOMINGO-FEIRA");
            System.out.println("8       |  FERIADO");
    
            System.out.print("\nINSIRA O CODIGO DO DIA DA SEMANA TRABALHADO (EX.: 1): ");
            int weekDay = scanner.nextInt();
    
            System.out.print("\nINSIRA SUA HORA DE ENTRADA (EX.: 09:00): ");
            String timeToClockIn = scanner.next();
    
            System.out.print("\nINSIRA SUA HORA DE SAIDA (EX.: 18:00): ");
            String timeToClockOut = scanner.next();
    
            System.out.print("\nINSIRA O VALOR QUE RECEBE POR HORA EXTRA (EX.: R$20,00): R$");
            double valueExtraHour = scanner.nextDouble();
    
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date formatTimeToClockIn = format.parse(timeToClockIn);
            Date formatTimeToClockOut = format.parse(timeToClockOut);
            long timeDifference = formatTimeToClockOut.getTime() - formatTimeToClockIn.getTime();
            long convertTime = (timeDifference / 3600000) % 24;
    
            if(convertTime > 8) {
    
                long extraHour = convertTime - 8;
                double additional = 0.00;
                double result = 0.00;
    
                if(weekDay >= 1 && weekDay <= 5) {
    
                    if(extraHour > 2) {
    
                        extraHour -= 2;
                        additional = ((2 * valueExtraHour) * 0.55) + ((extraHour * valueExtraHour) * 0.60);
                        extraHour += 2;
                        result = ((extraHour * valueExtraHour) + additional);
    
                        System.out.print("\nO VALOR TOTAL A RECEBER POR SUA HORA EXTRA E: " + (NumberFormat.getCurrencyInstance().format(result)));
                    }
    
                    else {
    
                        additional = ((extraHour * valueExtraHour) * 0.55);
                        result = ((extraHour * valueExtraHour) + additional);
    
                        System.out.print("\nO VALOR TOTAL A RECEBER POR SUA HORA EXTRA E: " + (NumberFormat.getCurrencyInstance().format(result)));
                    }
                }
    
                else if (weekDay >= 6 && weekDay <= 8) {
    
                    additional = ((extraHour * valueExtraHour) * 1);
                    result = ((extraHour * valueExtraHour) + additional);
    
                    System.out.print("\nO VALOR TOTAL A RECEBER POR SUA HORA EXTRA E: " + (NumberFormat.getCurrencyInstance().format(result)));
                }
    
                else{
    
                    System.out.print("\nCODIGO DO DIA DA SEMANA INCORRETO!");
                }
            }
    
            else {
    
                System.out.print("\nVALOR HORA EXTRA NAO FOI CALCULADO, POIS SEU EXPEDIENTE NAO ULTRAPASSOU 8 HORAS DE TRABALHO!");
            }

            scanner.close();
            
        } catch (Exception e) {

            System.out.print("\nINSIRA OS VALORES CORRETAMENTE!");
            scanner.close();
        }
	}
}