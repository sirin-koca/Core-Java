
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Det skal lages en klasse kalt Vind. Denne klassen skal beregne ut i fra en oppgitt vindhastighet i km/t
 * om det er stille (mindre enn 2 km/t) og om det er orkan (mer enn 120 km/t).
 * Videre skal klassen kunne beregne hvor mye vindhastigheten tilsvarer på Beaufort-skala (1-12).
 * Formelen for Beaufort er : (((vindhastighet i km/t) / 3.01)^0.6666)+0.5. ^ betyr opphøyd i.
 * Bruk gjerne Math.pow funksjonen for å foreta beregningen.
 * Til slutt skal det være mulig å regne ut antall knop i en metode. En knop er lik 1852 meter.
 * Bruk desimal formatering: String.format("%.2f", prisen);
 * Nedenfor illustreres hvordan klassen og metodene skal se ut:
 **/

class Vind {
    private double vindHastighet = 0.0;
    // Lag en konstruktør for å sette vindhastigheten

    public Vind(double vindHastighet) {
        this.vindHastighet = vindHastighet;
    }

    public double getVindHastighet() {
        return vindHastighet;
    }

    public void setVindHastighet(double vindHastighet) {
        this.vindHastighet = vindHastighet;
    }

    public boolean erOrkan() {
        if (vindHastighet > 120) {
            return true;
        }
        return false;
    }

    public boolean erVindstille() {
        if (vindHastighet < 2) {
            return true;
        }
        return false;
    }

    public double getKnop() {
        int knop = 1852;
        return (vindHastighet * knop) / 100;
    }

    public int getBeaufort() {
        double beaufort = (Math.pow((vindHastighet / 3.01), 0.6666) + 0.5);
        return (int) beaufort;
    }
}

public class Beaufort {
    public static void main(String[] args) {
        String innVind = showInputDialog("Skriv inn vindHastighet i km/t:");
        double vind = Double.parseDouble(innVind);

        Vind myVind = new Vind(vind);
        String ut = "The result: \n" +
                "Beaufort skala: " + myVind.getBeaufort() + "\n" +
                "Orkan risk: " + myVind.erOrkan() + "\n" +
                "Vindstille: " + myVind.erVindstille() + "\n" +
                "Knop: " + myVind.getKnop();

        showMessageDialog(null, ut);

    }
}