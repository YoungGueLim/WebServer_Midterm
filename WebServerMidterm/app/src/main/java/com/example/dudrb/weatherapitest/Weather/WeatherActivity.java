package com.example.dudrb.weatherapitest.Weather;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dudrb.weatherapitest.MedicalOrganization.MedicalOrg;
import com.example.dudrb.weatherapitest.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class WeatherActivity extends Activity {
    TextView textView;
    Document doc = null;
    LinearLayout layout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlparsing_domexample);

        textView = (TextView) findViewById(R.id.textView1);
    }

    public void onClick(View view){
        GetXMLTask task = new GetXMLTask();

        switch(view.getId()) {
            case R.id.button1:// 북구
                task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2723061000");
                break;
            case R.id.button: // 남구
                task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2720056000");
                break;
            case R.id.button2: // 서구
                task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2717051000");
                break;
            case R.id.button3: // 동구
                task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2714051000");
                break;
            case R.id.button4: // 수성구
                task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2726067000");
                break;
            case R.id.button5: // 달서구
                task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2729053500");
                break;
            case R.id.button6: // 달성군
                task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2771034000");
                break;
            case R.id.button7: // 중구
                task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2711051700");
                break;
            case R.id.button8:
                startActivity( new Intent(this,MedicalOrg.class) );
                finish();
                break;
        }
    }

    //private inner class extending AsyncTask
    private class GetXMLTask extends AsyncTask<String, Void, Document>{

        @Override
        protected Document doInBackground(String... urls) {
            URL url;
            try {
                url = new URL(urls[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder(); //XML문서 빌더 객체를 생성
                doc = db.parse(new InputSource(url.openStream())); //XML문서를 파싱한다.
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                Toast.makeText(getBaseContext(), "Parsing Error", Toast.LENGTH_SHORT).show();
            }
            return doc;
        }

        @Override
        protected void onPostExecute(Document doc) {

            String s = "";
            //data태그가 있는 노드를 찾아서 리스트 형태로 만들어서 반환

            NodeList list = doc.getElementsByTagName("channel");

            Node headerNode = list.item(0);
            Element headerElement = (Element)headerNode;

            // Title
            NodeList headerList = headerElement.getElementsByTagName("title");
            Element timeElement = (Element) headerList.item(0);
            headerList = timeElement.getChildNodes();

            String div = ((Node) headerList.item(0)).getNodeValue();
            s = s + div.substring(16) + "\n\n";
           /* s += "현재 시간 =  "+ div.substring(0,4)+ "년 "+
                    div.substring(5,6) + "월 " +
                    div.substring(7,8)+"일 " +
                    div.substring(8,10) + "시 " +
                    div.substring(10,12) + "분\n"
            ;*/
            //201604072300

            // 현재 시간
            NodeList currentrList = headerElement.getElementsByTagName("pubDate");
            Element currentElement = (Element) currentrList.item(0);
            currentrList = currentElement.getChildNodes();

            String div_current = ((Node) currentrList.item(0)).getNodeValue();
            s = s + div_current + "\n\n";

            //data 태그를 가지는 노드를 찾음, 계층적인 노드 구조를 반환
            NodeList nodeList = doc.getElementsByTagName("data");

            for(int i = 0; i< nodeList.getLength(); i++){

                //날씨 데이터를 추출
                //s += "" +i + ": 날씨 정보: ";
                Node node = nodeList.item(i); //data엘리먼트 노x드
                Element fstElmnt = (Element) node;

                NodeList timeList = fstElmnt.getElementsByTagName("hour");
                //<wfKor>맑음</wfKor> =====> <wfKor> 태그의 첫번째 자식노드는 TextNode 이고 TextNode의 값은 맑음
                s += "시간 = "+  timeList.item(0).getChildNodes().item(0).getNodeValue() +"시 ";

                // 온도
               NodeList nameList  = fstElmnt.getElementsByTagName("temp");
                Element nameElement = (Element) nameList.item(0);
                nameList = nameElement.getChildNodes();
                s += "온도 = "+ ((Node) nameList.item(0)).getNodeValue() +", ";

                // 날씨
                NodeList websiteList = fstElmnt.getElementsByTagName("wfKor");
                s += "날씨 = "+  websiteList.item(0).getChildNodes().item(0).getNodeValue() +"\n\n";
            }

            textView.setText(s);

            super.onPostExecute(doc);
        }

    }//end inner class - GetXMLTask

}
