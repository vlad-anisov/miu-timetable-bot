import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Schedule {

    public String Schedule(){
        String Schedule = "";
        try {
            Document doc = Jsoup.connect("http://miu.by/rus/schedule/schedule.php")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .requestBody("spec=%CF%F0%EE%E3%F0%E0%EC%EC%ED%EE%E5+%EE%E1%E5%F1%EF%E5%F7%E5%ED%E8%E5+%E8%ED%F4%EE%F0%EC%E0%F6%E8%EE%ED%ED%FB%F5+%F2%E5%F5%ED%EE%EB%EE%E3%E8%E9&group=181701%F1")
                    .post();

            //String s = doc.html();
            //System.out.println(s);
            Elements elements = doc.getElementsByAttributeValue("style", "border-collapse:collapse;width:100%;border:solid #999 1px;");
            for (Element el : elements) {
                Elements two = el.getElementsByTag("tr");
                for (Element elem: two ) {
                    String str = elem.attr("style");
                    String str2 = "background:#dfdfdf;border-top:solid #999 1px;";
                    if(str.equals(str2)){
                        //System.out.println();
                        Schedule = Schedule + "\n";
                    }
                    //System.out.println(elem.text());
                    Schedule = Schedule + elem.text() + "\n";
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return Schedule;
    }

}
