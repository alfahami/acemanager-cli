package constants;

import java.util.ArrayList;

import model.Card;
import model.City;
import model.Faculty;
import model.Field;
import model.Member;

public class FillTables {

    public final static ArrayList<Field> fillFieldsFs() {
        Field smi = new Field(1, "SMI", "Mathematics Science & Computer Science", "LF", 3);
        Field sma = new Field(2, "SMA", "Applied Mathematics Science", "LF", 3);
        Field smp = new Field(3, "SMP", "Mathematics Science & Physics", "LF", 3);
        Field mip = new Field(4, "MIP", "Mathematics Computer Science & Physics", "LF", 3);
        Field smc = new Field(5, "SMC", "Mathematics Science & Chemistry", "LF", 3);

        ArrayList<Field> fields = new ArrayList<>();
        fields.add(smi); fields.add(sma); fields.add(smp); fields.add(mip);
        fields.add(smc);

        return fields;
    }

    public final static ArrayList<Field> fillFieldsFsjes() {
        Field da = new Field(1, "DA", "Droit Arabe", "LF", 3);
        Field df = new Field(2, "DF", "Droit Français", "LF", 3);
        Field eg = new Field(3, "EG", "Economie & Gestion", "LF", 3);
        Field acg = new Field(4, "ACG", "Audit Control & Gestion", "LP", 3);
        Field tcf = new Field(5, "TCF", "Techniques Comptables & Financiers", "LP", 3);

        ArrayList<Field> fields = new ArrayList<>();
        fields.add(da); fields.add(df); fields.add(eg); fields.add(acg);
        fields.add(tcf);

        return fields;
    }

    public final static ArrayList<Field> fillFieldsEst() {
        Field dba = new Field(1, "DBA", "Database Administration", "LF", 3);
        Field ce = new Field(2, "CE", "Civil Engineering", "LF", 3);
        Field fbm = new Field(3, "FBM", "Financial Banking & Marketing", "LF", 3);
        Field sen = new Field(4, "SEN", "Software Engineering and Networking", "LP", 3);
        Field ewt = new Field(5, "EWT", "Environment Water & Techniques", "LP", 3);

        ArrayList<Field> fields = new ArrayList<>();
        fields.add(dba); fields.add(ce); fields.add(fbm); fields.add(sen);
        fields.add(ewt);

        return fields;
    }

    public final static ArrayList<Faculty> fillFaculties() {
        Faculty fs = new Faculty(1, "FS", "Faculty of Science", fillFieldsFs());
        Faculty fsjes = new Faculty(2, "FSJES", "Faculty of Science and Juridical Science", fillFieldsFsjes());
        Faculty fst = new Faculty(3, "FST", "Faculty of Science and Techniques", fillFieldsFs());
        Faculty est = new Faculty(4, "EST", "Superior School for Technology", fillFieldsEst());
        Faculty ensa = new Faculty(5, "ENSA", "Superior School for Technology", fillFieldsEst());

        ArrayList<Faculty> facs = new ArrayList<>();
        facs.add(fs); facs.add(fsjes); facs.add(fst); facs.add(est); facs.add(ensa);

        return facs;
    }

    public final static ArrayList<City> fillCities(ArrayList<Faculty> facs) {
        City fes = new City(1, "FES", "FES-BOULEMANE", facs);
        City meknes = new City(2, "MEKNES", "FES-BOULEMANE", facs);
        City oujda = new City(3, "OUJDA", "FES-BOULEMANE", facs);
        City kenitra = new City(4, "KENITRA", "RABAT-SALE-KENITRA", facs);
        City rabat = new City(5, "RABAT", "RABAT-SALE-KENITRA", facs);
        City sale = new City(6, "SALE", "FRABAT-SALE-KENITRA", facs);

        ArrayList<City> cities = new ArrayList<>();
        cities.add(fes); cities.add(meknes); cities.add(oujda); cities.add(kenitra); cities.add(rabat); cities.add(sale);

        return cities;

    }
    
    public final static ArrayList<Card> fillCards() {
        Card card1 = new Card(1, 1, 1, "C018409K", "STUDY", "23/09/2022", "23/09/2025", 1345);
        Card card2 = new Card(2, 2, 1, "C018409J", "STUDY", "26/11/2022", "23/09/2025", 1256);
        Card card3 = new Card(3, 3, 1, "C018508M", "WORK", "01/01/2023", "01/01/2026", 2398);
        Card card4 = new Card(4, 4, 1, "C018908P", "WORK", "05/05/2023", "05/05/2025", 9876);
        Card card5 = new Card(5, 5, 1, "C018409Z", "STUDY", "17/11/2022", "17/11/2025", 1345);

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(card1); cards.add(card2); cards.add(card3); cards.add(card4); cards.add(card5);

        return cards;
    }


    public final static ArrayList<Member> fillMembers() {
        Member mbr1 = new Member(1, "AMED", "ALI SAID", "12/09/1989", "amed@gmail.com", "nbe388409", 20212345, 1,  1, 1, 1, true);

        Member mbr2 = new Member(2, "HISSANE", "IRCHAD", "23/10/1990", "his@gmail.com", "nbe319590", 20212346, 2, 2, 2, 2, true);

        Member mbr3 = new Member(3, "CHARKAOUI", "ISSA", "03/03/1993", "issa@gmail.com", "nbe509879", 20212347, 3, 3, 3, 3, true);

        Member mbr4 = new Member(4, "MSA", "YOUSSOUF", "09/11/1990", "msa@gmail.com", "nbe388985", 20212345, 4, 4, 4, 4, true);

        Member mbr5 = new Member(5, "ILYASS", "HAIDAR", "08/01/2000", "ilys@gmail.com", "nbe388789", 20212345, 5, 5, 5, 5, true);

        ArrayList<Member> members = new ArrayList<>();
        members.add(mbr1); members.add(mbr2); members.add(mbr3); members.add(mbr4); members.add(mbr5);

        return members;
    }    
}
