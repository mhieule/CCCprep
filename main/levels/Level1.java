import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Level1 {

    public static void main(String[] args) {
        //Test 1
        System.out.println();
        //Test 2
        System.out.println();
        //Test 3
        System.out.println();
        //Test 4
        System.out.println();
        //Test 5
        System.out.println();
        //Test 6
        System.out.println();
        //Test 7
        System.out.println();
        //Test 8
        System.out.println();

        level3();
    }

    public static void mainMethodToSolveTheLevel() {

        FileInputStream fstream = null;
        ArrayList<String> processedInput= new ArrayList<>();
        try {
            fstream = new FileInputStream("level1_5.in");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String line;
            while ((line = br.readLine()) != null) {
                processedInput.add(line);
            }
            System.out.println(processedInput.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int numberOfMatches = Integer.parseInt(processedInput.get(0));


        String[] processedInputArray = processedInput.toArray(new String[0]);
        String[] matches = Arrays.copyOfRange(processedInputArray, 1, processedInputArray.length);

        File fout = new File("output1_5.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fout);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        try {
            bw.write(processedInputArray[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < matches.length; i++) {
            try {
                String currentMatch = matches[i];
                char playerA = currentMatch.toCharArray()[0];
                char playerB = currentMatch.toCharArray()[1];
                bw.write(currentMatch.toCharArray()[compare(playerA, playerB)]);
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        try {
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //read file by lines to store input in String array

        //split the array

        //foreach winning style determine the winner style
    }

    public static int compare(char a, char b){
        if(a=='R' && b=='S'){
            return 0;
        } else if (a=='S' && b=='P'){
            return 0;
        } else if (a=='P' && b=='R'){
            return 0;
        } else return 1;
    }

    public static void level2(){
        FileInputStream fstream = null;
        ArrayList<String> processedInput= new ArrayList<>();
        try {
            fstream = new FileInputStream("level2_5.in");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String line;
            while ((line = br.readLine()) != null) {
                processedInput.add(line);
            }
            System.out.println(processedInput.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] firstLine = processedInput.get(0).split(" ");
        int numberOfTourney = Integer.parseInt(firstLine[0]);
        int numberOfPlayerPerTourney = Integer.parseInt(firstLine[1]);

        String[] tourneys = processedInput.toArray(new String[0]);
        tourneys = Arrays.copyOfRange(tourneys, 1, tourneys.length);

        String finalResult = new String("");

        for (int i = 0; i < tourneys.length; i++) {
            String[] winnerFirstRound = new String[tourneys.length/2];
            String[] winnerSecondRound = new String[winnerFirstRound.length/2];

            String currentTourney = tourneys[i];
            char[] currentTourneyChar = currentTourney.toCharArray();
            char[] winnerFirstRoundChar = calculateWinnerOfRound(currentTourneyChar);
            char[] winnerSecondRoundChar = calculateWinnerOfRound(winnerFirstRoundChar);
            finalResult += new String(winnerSecondRoundChar) + "\n";
        }
        writeResult(finalResult);

        System.out.println(finalResult);

    }

    public static void level3(){
        FileInputStream fstream = null;
        ArrayList<String> processedInput= new ArrayList<>();
        try {
            fstream = new FileInputStream("level3_3.in");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String line;
            while ((line = br.readLine()) != null) {
                processedInput.add(line);
            }
            System.out.println(processedInput.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] firstLine = processedInput.get(0).split(" ");
        int numberOfTourney = Integer.parseInt(firstLine[0]);
        int numberOfPlayerPerTourney = Integer.parseInt(firstLine[1]);

        String[] tourneys = processedInput.toArray(new String[0]);
        tourneys = Arrays.copyOfRange(tourneys, 1, tourneys.length);


        String finalResult = new String("");

        for (int i = 0; i < tourneys.length; i++) {
            String currentTourney = tourneys[i];
            String[] currentTourneyString = currentTourney.split(" ");
            List<String> currentTourneyList = Arrays.stream(currentTourneyString).map(string -> string.substring(0, string.length()-1)).collect(Collectors.toList());
            int R = Integer.parseInt(currentTourneyList.get(0));
            int P = Integer.parseInt(currentTourneyList.get(1));
            int S = Integer.parseInt(currentTourneyList.get(2));
            String thisTourneyResult = new String("");

            /*while(true){
                String temp=generate(R, P, S);
                char[] currentTourneyChar = temp.toCharArray();
                char[] winnerFirstRoundChar = calculateWinnerOfRound(currentTourneyChar);
                char[] winnerSecondRoundChar = calculateWinnerOfRound(winnerFirstRoundChar);
                String test = new String(winnerSecondRoundChar);
                if (conditionCheck(test)) {
                    System.out.println(temp);
                    break;
                }

            }*/



        }

    }

    public static char[] calculateWinnerOfRound (char[] players){
        char[] result = new char[players.length/2];
        for (int i = 0; i < result.length; i++) {
            char player1 = players[i*2];
            char player2 = players[i*2+1];
            if(compare(player1, player2) == 0){
                result[i] = players[i*2];
            } else result[i] = players[i*2+1];
        }
        return result;

    }

    public static void writeResult(String text){
        File fout = new File("output2_2.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fout);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        try {
            bw.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public String generatePairings(int R, int P, int S){
        String result = new String("");
        int currentR=R;
        int currentP=P;
        int currentS=S;



        while (R/3 >= 1 && P>=1){
            result += "RRRP";
            currentR-=3;
            currentP--;
        }
        if(currentR<3){
            if(currentR==2){
                if(currentP >=2){
                    result+="RPRP";
                    currentR-=2;
                    currentP-=2;
                } else if(currentP == 1){
                    result+="RPRS";
                    currentS--;
                    currentR-=2;
                    currentP--;
                } else System.out.println("Reach the case where "+currentP+" "+currentR+" "+currentS);
            } else if(currentR==1){
                if(currentP>=3){
                    result+="RPPP";
                    currentR--;
                    currentP-=3;
                } else if(currentP==2){
                    result+="RPPS";
                    currentR--;
                    currentS--;
                    currentP-=2;
                } else if(currentP==1){
                    result+="RPSS";
                    currentR--;
                    currentP--;
                    currentS-=2;
                }
            }
        }



    return result;
    }

    public static String generate(int numR, int numP, int numS) {
        int length = numR + numP + numS;
        int usedR = 0;
        int usedP = 0;
        int usedS = 0;
        String endString = "";

        while (usedR + usedP + usedS < length) {
            int random = (int) (Math.random() * 3);
            if (random % 3 == 0) {
                if (usedR < numR) {
                    endString = endString + "R";
                    usedR++;
                }
            } else if (random % 3 == 1) {
                if (usedP < numP) {
                    endString = endString + "P";
                    usedP++;
                }
            } else {
                if (usedS < numS) {
                    endString = endString + "S";
                    usedS++;

                }
            }
        }
        return endString;
    }

    public static boolean conditionCheck(String match) {
        if (match.contains("S") && !match.contains("R")) {
            return true;
        }
        return false;
    }

    /*public static String generateSP(int S, int P){
        int current
        if(P/3>=1){

        }
    }

     */


}
