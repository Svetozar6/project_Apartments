package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static class UnsuitableApartmentsException extends Exception{
        public UnsuitableApartmentsException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        File file=new File("testData_Apartments.txt");
        try{
            Scanner sc=new Scanner(file);
            PrintWriter printWriter=new PrintWriter("Output.txt");
            List<Map.Entry<String, Double>> phones=new ArrayList<>();
            Map<String,Integer> gradoveBroqch=new HashMap<>();
            while(sc.hasNext()) {
                String city = sc.next();
                int rooms = sc.nextInt();
                int kvadratura = sc.nextInt();
                double tsena = sc.nextDouble();
                 String phone = sc.next();
                 Apartment ap=new Apartment(city,rooms,kvadratura,tsena,phone);
                if (gradoveBroqch.containsKey(city)) {
                    gradoveBroqch.put(city, gradoveBroqch.get(city) + 1);
                } else
                    gradoveBroqch.put(city, 1);
                if ((city.equals("София") || city.equals("Варна") || city.equals("Бургас")) && kvadratura > 100 && rooms == 3) {
                    phones.add(Map.entry(phone,tsena));
                }
                }
                sc.close();
                if(phones.isEmpty()) throw new UnsuitableApartmentsException("The aren't any suiting apartments.");
                phones.sort(Map.Entry.comparingByValue());
                for(Map.Entry p: phones){
                    //System.out.println(p.getKey()+" "+p.getValue());
                }

                Set<String> phonesSet=new LinkedHashSet<>();
                for(int i=0;i<Math.min(5, phones.size());i++){
                    phonesSet.add(phones.get(i).getKey());
                    //System.out.println(phones.get(i).getKey());
                }
                printWriter.print("Phones: ");
                for(String str : phonesSet){
                    printWriter.print(str+" ");
                }
                printWriter.println();
            System.out.println();
                List<Map.Entry<String,Integer>> cList=new ArrayList<>(gradoveBroqch.entrySet());
                cList.sort(Map.Entry.comparingByValue());
                Collections.reverse(cList);
                printWriter.print("Cities: ");
                for(Map.Entry entry : cList){
                    printWriter.print(entry.getKey()+" ");
                }
                printWriter.close();

        }catch(IOException | UnsuitableApartmentsException e){
            e.printStackTrace();
        }
    }
}
