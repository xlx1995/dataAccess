package com.xlx.util;


import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xlx
 * @descritption
 * @data 2019/12/8
 */
public class ProtobufUtil {

    private static Map<Class,Object> codecMap = new HashMap<>();

    private final static Object LOCK = new Object();

    public static <T> byte[] proToByte(Object obj) throws IOException {
        Class cls = obj.getClass();
        Codec<T> codec = getCodec(cls);
        byte[] encode = codec.encode((T)obj);
        return encode;
    }

    public static <T> T byteToCls(byte[] bytes, Class cls) throws IOException {
        Codec<T> codec = getCodec(cls);
        T decode = codec.decode(bytes);
        return decode;
    }

    public static <T> Codec<T>  getCodec(Class cls){
        synchronized (LOCK){
            if(codecMap.containsKey(cls)){
                return (Codec<T>)codecMap.get(cls);
            }else{
                Codec<T> codec = ProtobufProxy.create(cls);
                codecMap.put(cls,codec);
                return codec;
            }
        }
    }

}
