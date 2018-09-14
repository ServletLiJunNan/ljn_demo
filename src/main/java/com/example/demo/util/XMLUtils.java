package com.example.demo.util;

import com.example.demo.wxentity.TestMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.XMLStreamConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by za-lijunnan on 2018/8/24.
 */
public class XMLUtils {
    /**
     * xml转map
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public Map<String,String> xmlToMap(HttpServletRequest request) throws IOException,DocumentException{
        Map<String,String> map = new HashMap<String,String>();
        SAXReader reader = new SAXReader();
        InputStream in = request.getInputStream();
        Document doc = reader.read(in);
        Element root = doc.getRootElement();
        List<Element> list =root.elements();
        if(!CollectionUtils.isEmpty(list)){
            for (Element ele:list
                 ) {
                map.put(ele.getName(),ele.getText());
            }
        }
        return map;
    }

    public String messageToXml(TestMessage message){
        XStream stream = new XStream();
        stream.alias("xml",message.getClass());
        return stream.toXML(message);
    }
}
