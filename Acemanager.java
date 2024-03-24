import java.util.Arrays;

public class Acemanager {
    static final int INITIAL_SIZE = 10;
    private Member[] members = new Member[INITIAL_SIZE];
    private Formation[] formations = new Formation[INITIAL_SIZE];
    private StayCard[] stayCards = new StayCard[INITIAL_SIZE];
    private FacultyInstitute[] facultyInstitutes = new FacultyInstitute[INITIAL_SIZE];
    private City[] cities = new City[INITIAL_SIZE];

    public Acemanager(City[] cities, Formation[] formations, FacultyInstitute[] facs, Member[] members, StayCard[] cards){
        this.members = new Member[members.length];
        for (int i = 0; i < this.members.length; i++) {
            this.members[i] = new Member(members[i]);
            this.members[i].setIdMember(i+1);
        }     
        
        this.stayCards = new StayCard[cards.length];
        for (int i = 0; i < this.stayCards.length; i++) {
            this.stayCards[i] = new StayCard(cards[i]);
            this.stayCards[i].setIdCard(i+1);
        }   
        
        this.cities = new City[cities.length];
        for (int i = 0; i < this.cities.length; i++) {
            this.cities[i] = new City(cities[i]);
            this.cities[i].setIdCity(i+1);
        }  
        
        this.formations = new Formation[formations.length];
        for (int i = 0; i < this.formations.length; i++) {
            this.formations[i] = new Formation(formations[i]);
            this.formations[i].setIdFormation(i+1);
        }  

        this.facultyInstitutes = new FacultyInstitute[facs.length];
        for (int i = 0; i < this.facultyInstitutes.length; i++) {
            this.facultyInstitutes[i] = new FacultyInstitute(facs[i]);
            this.facultyInstitutes[i].setIdFacultyInstitute(i+1);
        }  
    }

    public Acemanager(Member[] members) {
        this.members = new Member[members.length];
        for (int i = 0; i < this.members.length; i++) {
            this.members[i] = new Member(members[i]);
            this.members[i].setIdMember(i+1);
        }        
    }

    public Acemanager(City[] cities){
        this.cities = new City[cities.length];
        for (int i = 0; i < cities.length; i++) {
            this.cities[i] = new City(cities[i]);
            this.cities[i].setIdCity(i+1);
        }
    }

    public Member getMember(int index) {
        return new Member(this.members[index]);
    }

    public void setMembers(Member[] members){
        Member[] copy = new Member[members.length];
        for (int i = 0; i < copy.length; i++) {
            this.members[i] = new Member(members[i]);
            this.members[i].setIdMember(i+1);        
        }
    }

    public void setMember(Member member, int index) {
       Member copy = new Member(member);
       this.members[index] = copy;
    }

    public Member[] getMembers(){
        return this.members;
    }

    public Formation getFormation(int i) {
        return new Formation(this.formations[i]);
    }

    public Formation[] getFormations(){
        return this.formations;
    }

    public void setFormation(Formation formation, int i) {
        Formation copy = new Formation(formation);
        this.formations[i] = copy;
    }

    public StayCard getStayCard(int i) {
        return new StayCard(this.stayCards[i]);
    }

    public void setStayCard(int i, StayCard stayCard) {
        StayCard copy = new StayCard(stayCard);
        this.stayCards[i] = copy;
    }

    public StayCard[] getCards(){
        return this.stayCards;
    }

    public City getCity(int i){
        return new City(this.cities[i]);
    }

    public void setCity(City city, int i){
        City copy = new City(city);
        this.cities[i] = copy;
    }

    public City[] getCities(){
        return this.cities;
    }

    public FacultyInstitute getFacultyInstitute(int i) {
        return new FacultyInstitute(this.facultyInstitutes[i]);
    }

    public FacultyInstitute[] getFaculties(){
        return this.facultyInstitutes;
    }

    public void setFaculty(FacultyInstitute fac, int i){
        FacultyInstitute copy = new FacultyInstitute(fac);
        this.facultyInstitutes[i] = copy;
    }
   
    public StayCard getCard(int i){
        return this.stayCards[i];
    }

    public void addMember(Member newMember){

        newMember.setIdMember(this.getMembers().length + 1);
        this.grow(members);
        this.setMember(newMember, this.getMembers().length - 1); 
        this.printAnyArrays(this.getMembers());
    }

    public boolean addCity(City newCity){
        if(newCity != null){
            newCity.setIdCity(this.getCities().length + 1);
            this.grow(cities);
            this.setCity(newCity, this.getCities().length - 1); 
            return true;
        } else {
            return false;
        }
    }

    public void addFaculty(FacultyInstitute newFac){
        newFac.setIdFacultyInstitute((this.getFaculties().length));
        this.grow(this.getFaculties());
        this.setFaculty(newFac, this.getFaculties().length - 1);
        this.printAnyArrays(this.getFaculties());
    }

    public void addFormation(Formation newFormation){
        newFormation.setIdFormation(this.getFormations().length);
        this.grow(this.getFaculties());
        this.setFormation(newFormation, this.getFormations().length - 1);
        this.printAnyArrays(this.getFormations());
    }

    public void grow(Object[] arrays){
        
        String className = arrays.getClass().getCanonicalName(); 

        switch(className){
            case "Member[]":
                this.members = new Member[arrays.length + 1];
                for (int i = 0; i < arrays.length; i++) {
                    this.members[i] = new Member((Member)arrays[i]);
                    this.members[i].setIdMember(i+1);
                } 
                break;
            case "City[]":
            this.cities = new City[arrays.length + 1];
            for (int i = 0; i < arrays.length; i++) {
                this.cities[i] = new City((City)arrays[i]);
                this.cities[i].setIdCity(i+1);
            } 
            break;
            case "Faculty[]":
                this.facultyInstitutes = new FacultyInstitute[arrays.length + 1];
                for (int i = 0; i < arrays.length; i++) {
                    this.facultyInstitutes[i] = new FacultyInstitute((FacultyInstitute) arrays[i]);
                    this.facultyInstitutes[i].setIdFacultyInstitute(i+1);
                }
                break;
            case "Formation[]":
                this.formations = new Formation[arrays.length + 1];
                for (int i = 0; i < arrays.length; i++) {
                    this.formations[i] = new Formation((Formation) arrays[i]);
                    this.formations[i].setIdFormation(i+1);
                }
                break;
            case "StayCard[]":
                this.stayCards = new StayCard[arrays.length];
                for (int i = 0; i < arrays.length; i++) {
                    this.stayCards[i] = new StayCard((StayCard) arrays[i]);
                    this.stayCards[i].setIdCard(i+1);
                }
                break;
            case "Role[]":
                break;
            default:
                break;
        }
    } 

    public boolean checkPassport(String passport){
        for (int i = 0; i < this.members.length; i++) {
            String storedPassport = members[i].getPassport().toString();
            if(passport.equals(storedPassport)) return true;
        }
        return false;
    }
    
    public boolean checkCin(String cin){
        for (int i = 0; i < this.stayCards.length; i++) {
            if(cin.equals(stayCards[i].getCardNum())) return true;
        }
        return false;
    }

    public boolean checkMatAMCI(int mat){
       for (int i = 0; i < this.members.length; i++) {
            if(mat == members[i].getMatriculeAmci()) return true;
       }
       return false;
        
    }

    public boolean checkCity(String city){
        for (int i = 0; i < this.cities.length; i++) {
            if(city.equals(cities[i].getName())) return true;
        }
        return false;
    }
    
    public void printAnyArrays(Object[] arrays){
        if(arrays != null){
            String className = arrays.getClass().getCanonicalName();           
                // switch array instance
                //String className = arrays[i].getClass().getName();
                switch(className){
                    case "Member[]":
                        System.out.println(printTableTitle("LIST OF ACEM MEMBERS"));
                        System.out.print("\n  ID | \t   FULL NAME  \t  | AGE | PASSPORT  | MAT AMCI |   CIN    |   PATTERN   |    CITY    |      FORMATION       |   DIPLOMA   | FACULTY | ADHESION |       EMAIL       |\n ----|--------------------|-----|-----------|----------|----------|-------------|------------|----------------------|-------------|---------|----------|-------------------|\n");
                        for (int i = 0; i < arrays.length; i++) {
                            
                            Member member = getMember(i);
            
                    /*#### HACK TO HAVE AN AWESOME DISPLAY OF THE ARRAY IN THE CONSOLE */
            
                            // we used ternary for displayind id in the same column no matter how many digits it holds
                            String fullName = member.getFirstName() + " " + member.getLastName();
            
                            // THINK ABOUT USING STRINGBUILDER as it offers a set length, the idea would be to print all the Stringbuilder object and when no value found print space
                            
                    /*### HACK ENDS  */
                        System.out.println( printId(i, member.getIdMember())+ " | " + formatString(fullName, 17) + "| " + member.getAge() + "  | " + member.getPassport() + " | "  + member.getMatriculeAmci() + " | " + getCardById(member.getIdStayCard()).getCardNum() + " | " + formatString(getCardById(member.getIdStayCard()).getPattern(), 10) + "| " + formatString(getCityName(member.getIdCity()), 9)  + "| " + formatString(getFormationMember(member.getIdFormation()).getName(), 19) + "| " + formatString(getFormationMember(member.getIdFormation()).getFCertificate(), 10) + "| " + formatString(getMemberFaculty(member.getIdFacultyInstitute()).getNameFacInst(), 6) + "| " + (member.isMember() == true ? (formatString("YES ", 6)) : (formatString("NO ", 6))) + " | " + formatString(getMember(i).getEmail(), 16) + "|");
                        System.out.print(i < arrays.length - 1 ? " ----|--------------------|-----|-----------|----------|----------|-------------|------------|----------------------|-------------|---------|----------|-------------------|\n" : "\n\n");
                        }
                        break;
                    case "City[]":
                    System.out.println(printTableTitle("LIST OF CITIES"));
                        System.out.println("");
                        System.out.print("\n\t\t\t\t     ID |\tCITY       |\t\tREGION\t          |   \t\tFACULTIES\t\t |\n\t\t\t\t    ----|------------------|------------------------------|--------------------------------------|\n");
                        for (int i = 0; i < arrays.length; i++) {
                            City city = this.getCity(i);
                            System.out.println("\t\t\t\t   " + printId(i, city.getIdCity()) + " | " + formatString(city.getName(), 14) + " | " + formatString(city.getRegion(), 26) + " | "  + Arrays.toString(city.getFacs()) + "  |");
                            System.out.print((i < arrays.length - 1) ? "\t\t\t\t    ----|------------------|------------------------------|--------------------------------------|\n" : "\n\n");
                        }
                        break;
                    case "Formation[]":
                        System.out.println(printTableTitle("LIST OF FORMATIONS"));
                        System.out.print("\n\t\t\t\t\t\t  ID |    FORMATION NAME    | CERTIFICATE    |  DURATION \t  |\n\t\t\t\t\t\t ----|----------------------|----------------|--------------------|\n");
                        for (int i = 0; i < arrays.length; i++) {
                            Formation formation = getFormation(i);
                            System.out.println("\t\t\t\t\t\t" + printId(i, formation.getIdFormation()) + " | " + formatString(formation.getName(), 18) + " | " + formatString(formation.getFCertificate(), 12) + " | " + formation.getDuration() + "\t\t  |");
                            System.out.print((i < arrays.length - 1) ? "\t\t\t\t\t\t ----|----------------------|----------------|--------------------|\n" : "\n\n");
                        }
                        break;
                    case "FacultyInstitute[]":
                        System.out.println(printTableTitle("LIST OF FACULTIES"));
                        System.out.print("\n\t\t     ID |    FACULTY    | \t\t\t\t\t\t\tFORMATIONS\t\t\t\t\t\t  |\n\t\t    ----|---------------|-----------------------------------------------------------------------------------------------------------------|\n");
                        for (int i = 0; i < arrays.length; i++) {
                            FacultyInstitute fac = getFacultyInstitute(i);
                            System.out.println("\t\t   " + printId(i, fac.getIdFacultyInstitute()) + " | " + formatString(fac.getNameFacInst(), 11) + " | " + Arrays.toString(fac.getFormationNames()) + " |" );
                            //System.out.println("\t ----|---------------|------------------------------------------------------------------------------------------------------------------");
                            System.out.print((i < arrays.length - 1) ? "\t\t    ----|---------------|-----------------------------------------------------------------------------------------------------------------|\n" : "\n\n");
                        }
                        break;
                    case "StayCard[]":
                        System.out.println(printTableTitle("LIST OF STAY CARDS"));
                        System.out.print("\n\t\t\t     ID | \tFULL NAME\t  | BIRTH DATE |   CIN    |  STAY REASON | OBTENTION DATE | EXPIRATION DATE |  PIN   |\n\t\t\t    ----|-------------------------|------------|----------|--------------|----------------|-----------------|--------|\n");
                        for (int i = 0; i < arrays.length; i++) {
                            StayCard card = getCard(i);
                            System.out.println("\t\t\t   " + printId(i, card.getIdCard()) + " | " + formatString(getMemberCard(card.getIdMember()).getFirstName() + " " + getMemberCard(card.getIdMember()).getLastName(), 21) + " | " + getMemberCard(card.getIdMember()).getBirthDate() + " | " + card.getCardNum() + " | "+ formatString(card.getPattern(), 10) + " | " + formatString(card.getObtentionDate(), 12) + " | " + formatString(card.getExpirationDate(), 13) + " | " + card.getPin() + " |");
                            System.out.print((i < arrays.length - 1) ? "\t\t\t    ----|-------------------------|------------|----------|--------------|----------------|-----------------|--------|\n" : "\n\n");
                        }
                        break;
                        default:
                            System.out.println("The fuck you trying to do though");
                }
        } else System.exit(0);
    }

    public StayCard getCardById(int idStayCard){
            for (int j = 0; j < this.stayCards.length; j++) {
                if(idStayCard == getStayCard(j).getIdCard()){
                    return getStayCard(j);
                } 
            }
            return null;   
    }

    public String getCityName(int idCity){
        String cityName = "";
            for (int j = 0; j < this.cities.length; j++) {
                if(idCity == getCity(j).getIdCity()){
                    cityName = getCity(j).getName();
                } 
            }
        return cityName; 
    }

    public Formation getFormationMember(int idFormation){
            for (int j = 0; j < this.formations.length; j++) {
                if(idFormation == getFormation(j).getIdFormation()){
                   return getFormation(j);
                } 
            }
            return null; 
    }

    public FacultyInstitute getMemberFaculty(int idFacultyInstitute){
            for (int j = 0; j < this.facultyInstitutes.length; j++) {
                if(idFacultyInstitute == getFacultyInstitute(j).getIdFacultyInstitute()){
                    return new FacultyInstitute(facultyInstitutes[j]);
                } 
            }
            return null; 
    }

    public String getCertificateName(int idFormation){
        String certifName = "";
            for (int j = 0; j < this.formations.length; j++) {
                if(idFormation == getFormation(j).getIdFormation()){
                    certifName = getFormation(j).getFCertificate();
                } 
            }
            return certifName; 
    }

    public Member getMemberCard(int idMember){
        Member member = new Member();
        for (int i = 0; i < this.members.length; i++) {
            if(idMember == getMember(i).getIdMember()){
                member = getMember(i);
                return member;
            }
        }
        return null;
    }

    public String formatString(String s, int i){
        String space = " ";
        if(s.length() < i){
            for (int j = 0; j <= i- s.length(); j++) {
                space += " "; 
            }
        }
        return s + space;
    }

    public String printId(int i, int id){
        return ( i < 9 ?  ("  " + String.valueOf(id)) + " " : (" " + String.valueOf(id)) + " ");
    }

    public String printTableTitle(String tTitle){
        return "\n\t\t\t\t\t\t\t\t\t==========================\n\t\t\t\t\t\t\t\t\t\s\s\s" + tTitle + "\n\t\t\t\t\t\t\t\t\t==========================\n";
    }
}
