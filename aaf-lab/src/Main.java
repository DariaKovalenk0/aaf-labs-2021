import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static String C1 = "[cC][rR][eE][aA][tT][eE]";
    public static String C2 = "[iI][nN][sS][eE][rR][tT]";
    public static String C3 = "[pP][rR][iI][nN][tT][_][tT][rR][eE][eE]";
    public static String C4 = "[cC][oO][nN][tT][aA][iI][nN][sS]";
    public static String C5 = "[sS][eE][aA][rR][cC][hH]";
    public static String C51 = "[cC][oO][nN][tT][aA][iI][nN][eE][dD][_][bB][yY]";
    public static String C52 = "[iI][nN][tT][eE][rR][sS][eE][cC][tT][sS]";
    public static String C53 = "[rR][iI][gG][hH][tT][_][oO][fF]";
    public static String C6 = "[wW][hH][eE][rR][eE]";
    public static void main(String []args){
        ArrayList<Base> base = new ArrayList<Base>();
        String res="";
        Scanner in = new Scanner(System.in);
        boolean check=true;
        //Comand c = ParseCommand("search f where riGHt_oF [155,5];");
        //System.out.println(!"01".matches("[0]|[1-9][0-9]*")||!"5".matches("[0]|[1-9][0-9]*"));
        //System.out.println(c.name+" "+c.comNumber+" "+c.argName);
        while(check){
            System.out.println("Enter command:");
            String sRead = res;
            sRead+=in.nextLine();
            sRead+=" ";
            String []sarr = sRead.split(";");
            res = sarr[sarr.length-1];
            for(int i=0;i<sarr.length-1;i++){
                Comand c = ParseCommand(sarr[i]);
                if(c.comNumber==0){
                    return;
                }
                ExecuteCommand(base,c);
                //System.out.println(c.name+" "+c.comNumber+" "+c.argName);
            }
        }

    }
    public static Comand ParseCommand(String s1){
        Comand ret= new Comand();
        s1 = s1.trim();
        s1 = s1.replace("\s"," ");
        s1= s1.replace("\n"," ");
        s1 = s1.replace("\r"," ");
        s1 = s1.replace(";","");
        s1 = s1.replace(",\s",",");
        s1 = s1.replaceAll("( )+"," ");
        String []str = s1.split(" ");
        if(s1.toLowerCase(Locale.ROOT).matches("[.exit]")){
            ret.error=true;
            ret.comNumber=0;
            return ret;
        }
        if(str.length!=2&&str.length!=3&&str.length!=5){
            ret.error=true;
            ret.name = "unknown command!";
            return ret;
        }
        else if(str.length==2){
            if(str[0].matches(C1)){
                if(str[1].matches("[a-zA-Z][a-zA-Z0-9_]*")){
                    ret.comNumber=1;
                    ret.name=str[1];
                }else{
                    ret.error=true;
                    ret.name="bad name!";
                }
                return ret;
            }
            if(str[0].matches(C3)){
                if(str[1].matches("[a-zA-Z][a-zA-Z0-9_]*")){
                    ret.comNumber=3;
                    ret.name=str[1];
                }else{
                    ret.error=true;
                    ret.name="bad name!";
                }
                return ret;
            }
            if(str[0].matches(C5)){
                if(str[1].matches("[a-zA-Z][a-zA-Z0-9_]*")){
                    ret.comNumber=50;
                    ret.name=str[1];
                }else{
                    ret.error=true;
                    ret.name="bad name!";
                }
                return ret;
            }
            else{
                ret.error=true;
                ret.name= "unknown command!";
                return ret;
            }
        }
        else if(str.length==3){
            if(str[0].matches(C2)){
                if(str[1].matches("[a-zA-Z][a-zA-Z0-9_]*")){
                    ret.comNumber=2;
                    ret.name=str[1];
                    if(str[2].matches("[\\[][0-9]*[,][0-9]*[\\]]")){
                        String s = str[2].replace("[","");
                        s = s.replace("]","");
                        String []as = s.split(",");
                        if(!as[0].matches("[0]|[1-9][0-9]*")||!as[1].matches("[0]|[1-9][0-9]*")){
                            ret.error=true;
                            ret.name="bad argument values!";
                            return ret;
                        }
                        ret.argName=s;
                        return ret;
                    }
                    else{
                        ret.error=true;
                        ret.name="bad argument!";
                        return ret;
                    }
                }else{
                    ret.error=true;
                    ret.name="bad name!";
                    return ret;
                }
                //return ret;
            }
            if(str[0].matches(C4)){
                if(str[1].matches("[a-zA-Z][a-zA-Z0-9_]*")){
                    ret.comNumber=4;
                    ret.name=str[1];
                    if(str[2].matches("[\\[][0-9]*[,][0-9]*[\\]]")){
                        String s = str[2].replace("[","");
                        s = s.replace("]","");
                        String []as = s.split(",");
                        if(!as[0].matches("[0]|[1-9][0-9]*")||!as[1].matches("[0]|[1-9][0-9]*")){
                            ret.error=true;
                            ret.name="bad argument values!";
                            return ret;
                        }
                        ret.argName=s;
                        return ret;
                    }
                    else{
                        ret.error=true;
                        ret.name="bad argument!";
                        return ret;
                    }
                }else{
                    ret.error=true;
                    ret.name="bad name!";
                    return ret;
                }
                //return ret;
            }
            else{
                ret.error=true;
                ret.name= "unknown command!";
                return ret;
            }
        }
        else if(str.length==5){
            if(str[0].matches(C5)){
                if(str[2].matches(C6))
                {
                    if(str[1].matches("[a-zA-Z][a-zA-Z0-9_]*")){
                        ret.name=str[1];
                    }else{
                        ret.error=true;
                        ret.name= "bad name!";
                        return ret;
                    }
                    if(str[3].matches(C51)){
                        ret.comNumber=51;
                        if(str[4].matches("[\\[][0-9]*[,][0-9]*[\\]]")){
                            String s = str[4].replace("[","");
                            s = s.replace("]","");
                            String []as = s.split(",");
                            if(!as[0].matches("[0]|[1-9][0-9]*")||!as[1].matches("[0]|[1-9][0-9]*")){
                                ret.error=true;
                                ret.name="bad argument values!";
                                return ret;
                            }
                            ret.argName=s;
                            return ret;
                        }
                        else{
                            ret.error=true;
                            ret.name="bad argument!";
                            return ret;
                        }
                    }
                    else if(str[3].matches(C52)){
                        ret.comNumber=52;
                        if(str[4].matches("[\\[][0-9]*[,][0-9]*[\\]]")){
                            String s = str[4].replace("[","");
                            s = s.replace("]","");
                            String []as = s.split(",");
                            if(!as[0].matches("[0]|[1-9][0-9]*")||!as[1].matches("[0]|[1-9][0-9]*")){
                                ret.error=true;
                                ret.name="bad argument values!";
                                return ret;
                            }
                            ret.argName=s;
                            return ret;
                        }
                        else{
                            ret.error=true;
                            ret.name="bad argument!";
                            return ret;
                        }
                    }
                    else if(str[3].matches(C53)){
                        ret.comNumber=53;
                        if(str[4].matches("[\\[][0-9]*[,][0-9]*[\\]]")){
                            String s = str[4].replace("[","");
                            s = s.replace("]","");
                            String []as = s.split(",");
                            if(!as[0].matches("[0]|[1-9][0-9]*")||!as[1].matches("[0]|[1-9][0-9]*")){
                                ret.error=true;
                                ret.name="bad argument values!";
                                return ret;
                            }
                            ret.argName=s;
                            return ret;
                        }
                        else{
                            ret.error=true;
                            ret.name="bad argument!";
                            return ret;
                        }
                    }
                }
            }
            ret.error=true;
            ret.name= "unknown command!";
            return ret;
        }
        else{
            ret.error=true;
            ret.name="unknown command!";
            return ret;
        }
        //return ret;

    }

    public static void ExecuteCommand(ArrayList<Base> lst,Comand comand){
        //System.out.println(lst.toArray().length);
        if(comand.comNumber==1){
            //System.out.println(" ");
            for(int i=0;i<lst.toArray().length;i++){
                //System.out.println(lst.get(i).s1);
                if(comand.name.equals(lst.get(i).s1)){
                    System.out.println(comand.name+" already exist!");
                    return;
                }
            }
            KDTree tr = new KDTree();
            Base b = new Base();
            b.tree=tr;
            b.s1=comand.name;
            lst.add(b);
            return;
        }
        if(comand.comNumber==2){
            int check=0;
            for(int i=0;i<lst.toArray().length;i++){
                if(comand.name.equals(lst.get(i).s1)){
                    check=1;
                }
            }
            if(check==0){
                System.out.println(comand.name+" does not exist!");
                return;
            }
            //
        }
    }
}
