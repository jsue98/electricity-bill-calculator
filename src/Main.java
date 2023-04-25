public class Main {
    public static void main(String[] args) {
        int[] electUsage = new int[]{99, 150, 250, 301, 450, 510}; //전기 사용량 저장 배열
        double[] result = new double[6];// 전기 요금 계산 결과 배열
        int i, remain = 0;//i는 배열 인데스 변수, remain은 사용량의 십의자리 이하 값 저장 배열

        //100kWh 이하는 kWh당 60.7월
        //100kWh 초과는 125.9원
        //200kWh 초과는 187.9원
        //300kWh 초과는 280.6원
        //400kWh 초과는 417.7원
        //500kWh 초과는 670.6원

        System.out.println("=========================");
        System.out.println(" 주택용 전기요금(저압) 계산기 ");
        System.out.println("=========================");

        for(i = 0 ; i < 6 ; i++){
            if(electUsage[i] > 500){//500kWh 초과
                remain = electUsage[i] % 500;
                result[i] = (100 * 60.7) + (100 * 125.9) + (100 * 187.9) + (100 * 280.6) + (100 * 417.7) + (remain * 670.6);
            }
            else if(electUsage[i] > 400){//400kWh 초과
                remain = electUsage[i] % 400;
                result[i] = (100 * 60.7) + (100 * 125.9) + (100 * 187.9) + (100 * 280.6) + (remain * 417.7);
            }
            else if(electUsage[i] > 300){//300kWh 초과
                remain = electUsage[i] % 400;
                result[i] = (100 * 60.7) + (100 * 125.9) + (100 * 187.9) + (remain * 280.6);
            }
            else if(electUsage[i] > 200){//200kWh 초과
                remain = electUsage[i] % 200;
                result[i] = (100 * 60.7) + (100 * 125.9) + (remain * 187.9);
            }
            else if(electUsage[i] > 100){//100kWh 초과
                remain = electUsage[i] % 100;
                result[i] = (100 * 60.7) + (remain * 125.9);
            }
            else if(electUsage[i] <= 100){//100kWh 이하
                result[i] = electUsage[i] * 60.7;
            }
        }
        for(i = 0 ; i < electUsage.length ; i++){
            System.out.printf("%dkWh의 전기 요금은 %.1f원 입니다.%n", electUsage[i], result[i]);
        }
    }
}