package gravityguy;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.Reader;

class gg
{
    static int arr[];
    public void FindAnswer(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        int n = Integer.parseInt(br.readLine());
        String up = "";
        String down = "";
        String ans[] = new String[n];
        int count[] = new int[n];
        arr = count;
        int pos = 0;
        for (int i = 0;i<n;i++){
            up=br.readLine();
            down=br.readLine();
            ans[i]=doIt(up,down,i);
        }
        for (int k = 0;k<ans.length;k++){
            System.out.println(ans[k]);
            if (ans[k].equals("No")==false)
                System.out.println(arr[k]);
        }
    }

    public static String doIt(String uu , String dd , int posi)
    {
        String d = "";String u = "";
        int c = 0;boolean end = false;int pos = 0;String s = "";
        if(uu.charAt(0)=='.'){
            d = uu;
            u = dd;
        }
        else if (dd.charAt(0)=='.'){
            d = dd;
            u = uu;
        }
        else {
            end = true;
            return "No";
        }
        while(end==false&&pos<d.length())
        {
            if(pos<d.length()-1){

                if(d.charAt(pos+1)=='.'){
                    pos++;
                }

                else if (d.charAt(pos+1)=='#'){

                    if(u.charAt(pos+1)=='.'){

                        s = d;
                        d = u;
                        u = s;

                        pos++;
                        c++;
                    }
                    else if(u.charAt(pos)=='.'){
                        s = u;
                        d = u;
                        u = s;
                        c++;
                    }
                    else{end = true;return"No";}
                }
            }
            else end = true;
        }
        if(pos>=d.length()-1){
            arr[posi]=c;
            return "Yes";
        }
        else
            return "No";
    }

    public static void main(String args[]) throws java.lang.Exception
    {
        gg hi = new gg();
        hi.FindAnswer(new InputStreamReader(System.in));
    }
}
