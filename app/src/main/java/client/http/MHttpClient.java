package client.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ridwan-p on 4/16/16.
 */
public class MHttpClient
{

    protected String base_url = null;

    public MHttpClient(String url)
    {
        base_url = url;
    }

    public String getData(String loc)
    {
        HttpURLConnection con = null;
        InputStream is = null;

        try
        {
            con = (HttpURLConnection) (new URL(base_url + loc)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            StringBuffer buffer = new StringBuffer();
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null)
                buffer.append(line + "rn");

            is.close();
            con.disconnect();
            return buffer.toString();
        } catch (Throwable t)
        {
            t.printStackTrace();
        } finally
        {
            try
            {
                is.close();
            } catch (Throwable t)
            {
            }
            try
            {
                con.disconnect();
            } catch (Throwable t)
            {
            }
        }

        return null;

    }
}
