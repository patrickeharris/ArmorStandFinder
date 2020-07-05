package MCR;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;







public class CompressedStreamTools
{
  public static NBTTagCompound func_1138_a(InputStream inputstream) throws IOException {
    DataInputStream datainputstream = new DataInputStream(new GZIPInputStream(inputstream));
    
    try {
      NBTTagCompound nbttagcompound = func_1141_a(datainputstream);
      return nbttagcompound;
    }
    finally {
      
      datainputstream.close();
    } 
  }


  
  public static void writeGzippedCompoundToOutputStream(NBTTagCompound nbttagcompound, OutputStream outputstream) throws IOException {
    DataOutputStream dataoutputstream = new DataOutputStream(new GZIPOutputStream(outputstream));
    
    try {
      func_1139_a(nbttagcompound, dataoutputstream);
    }
    finally {
      
      dataoutputstream.close();
    } 
  }


  
  public static NBTTagCompound func_1141_a(DataInput datainput) throws IOException {
    NBTBase nbtbase = NBTBase.readTag(datainput);
    if (nbtbase instanceof NBTTagCompound)
    {
      return (NBTTagCompound)nbtbase;
    }
    
    throw new IOException("Root tag must be a named compound tag");
  }




  
  public static void func_1139_a(NBTTagCompound nbttagcompound, DataOutput dataoutput) throws IOException { NBTBase.writeTag(nbttagcompound, dataoutput); }
}
