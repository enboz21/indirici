public class ne {
    
    private String[] f;
    private String[] d;
    public void ne(String uzun){
        String[] böl = uzun.split("\n", 100);
        System.out.println(uzun);
        
        
        int a=böl.length;
        int s=0;
         f=new String[a-5];
        for (int i = 5; i < böl.length; i++) {
            String[] böl2=böl[i].split(" ");
            f[s]=böl2[0];
            s++;
        }
        s=0;
        d=new String[a-5];
        for (int i = 5; i < böl.length; i++) {
            d[s]=böl[i];
            s++;
        }
        
    }
    public String [] deyerler(){
        return f;
    }
    public String [] formatlar(){
        return d;
    }
}
