package com.glot.gameiotest;

import java.io.UnsupportedEncodingException;

import com.ET199.ET199;
import com.ET199.ET_EXCEPTION;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener{
	
	private static final String TAG = "GameIO-Test";
	
	
	private Button	led1on,led1off,led1blink;
	private Button	led2on,led2off,led2blink;
	private Button	led3on,led3off,led3blink;
	private Button	led4on,led4off,led4blink;
	private Button	led5on,led5off,led5blink;
	private Button	led6on,led6off,led6blink;
	
	private Button  rfButton;
	
	private Button  doorButton;
	
	private Button  systemButton;
	
	private Button  upsButton;
	
	private Button  openKeypad,closeKeypad;
	
	private Button  readKeypadButton,writeKeypadButton;
	
	private Button  openTest,closeTest;
	
	private TextView rfSN;
	
	private TextView readKeypadSN,writeKeypadSN;
	
	private TextView upsVoltage,upsStatus;
	
	private EditText pinText;
	
	
	
	private CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
	
	private Button   key1,key2,key3,key4,key5,key6,key7,key8,key9,key0;
	
	private Button   keySpace,keyDot,keyCancel,keyEnter,keyClear;
	
	private Button 	 usbkeyButton;
	
	private TextView usbkeySN;
	
	boolean mBound;
	
	boolean mSystem;
	
	int		mKeypadFunction;//键盘功能
	
	private Messenger mService = null;
	
	private final Messenger mMessenger = new Messenger(new IncomingHandler());

	
	
	private ServiceConnection mConnection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName arg0, IBinder service) {
			// TODO Auto-generated method stub
			mService=new Messenger(service);
			mBound=true;
		}

		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			// TODO Auto-generated method stub
			mService=null;
			mBound=false;
		}
		
	};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        led1on=(Button)findViewById(R.id.led1on);
        led1off=(Button)findViewById(R.id.led1off);
        led1blink=(Button)findViewById(R.id.led1blink);
        led1on.setOnClickListener(this);
        led1off.setOnClickListener(this);
        led1blink.setOnClickListener(this);
        
        led2on=(Button)findViewById(R.id.led2on);
        led2off=(Button)findViewById(R.id.led2off);
        led2blink=(Button)findViewById(R.id.led2blink);
        led2on.setOnClickListener(this);
        led2off.setOnClickListener(this);
        led2blink.setOnClickListener(this);
        
        led3on=(Button)findViewById(R.id.led3on);
        led3off=(Button)findViewById(R.id.led3off);
        led3blink=(Button)findViewById(R.id.led3blink);
        led3on.setOnClickListener(this);
        led3off.setOnClickListener(this);
        led3blink.setOnClickListener(this);
        
        led4on=(Button)findViewById(R.id.led4on);
        led4off=(Button)findViewById(R.id.led4off);
        led4blink=(Button)findViewById(R.id.led4blink);
        led4on.setOnClickListener(this);
        led4off.setOnClickListener(this);
        led4blink.setOnClickListener(this);
        
        led5on=(Button)findViewById(R.id.led5on);
        led5off=(Button)findViewById(R.id.led5off);
        led5blink=(Button)findViewById(R.id.led5blink);
        led5on.setOnClickListener(this);
        led5off.setOnClickListener(this);
        led5blink.setOnClickListener(this);
        
        led6on=(Button)findViewById(R.id.led6on);
        led6off=(Button)findViewById(R.id.led6off);
        led6blink=(Button)findViewById(R.id.led6blink);
        led6on.setOnClickListener(this);
        led6off.setOnClickListener(this);
        led6blink.setOnClickListener(this);
        
        
        rfButton=(Button)findViewById(R.id.rfButton);
        rfSN=(TextView)findViewById(R.id.snTextView);
        
        rfButton.setOnClickListener(rfClick);
        
        
        
        doorButton=(Button)findViewById(R.id.doorButton);
        systemButton=(Button)findViewById(R.id.systemButton);
        
        checkBox1=(CheckBox)findViewById(R.id.checkBox1);
        checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        checkBox3=(CheckBox)findViewById(R.id.checkBox3);
        checkBox4=(CheckBox)findViewById(R.id.checkBox4);
        doorButton.setOnClickListener(doorClick);
        
        systemButton.setOnClickListener(systemClick);
        
        //ups function 
        upsButton=(Button)findViewById(R.id.upsButton);
        upsVoltage=(TextView)findViewById(R.id.uspVoltage);
        upsStatus=(TextView)findViewById(R.id.upsStatus);
        
        upsButton.setOnClickListener(upsClick);
        
        
        
        //keypad function
        openKeypad=(Button)findViewById(R.id.openKeypad);
        closeKeypad=(Button)findViewById(R.id.closeKeypad);
        readKeypadButton=(Button)findViewById(R.id.readKeypadButton);
        writeKeypadButton=(Button)findViewById(R.id.writeKeypadButton);
        
        openKeypad.setOnClickListener(openKeypadClick);
        closeKeypad.setOnClickListener(closeKeypadClick);
        
        readKeypadButton.setOnClickListener(readKeypadClick);
        writeKeypadButton.setOnClickListener(writeKeypadClick);
        
        readKeypadSN=(TextView)findViewById(R.id.readKeypadSN);
        writeKeypadSN=(TextView)findViewById(R.id.writeKeypadSN);
        
        openTest=(Button)findViewById(R.id.openTest);
        closeTest=(Button)findViewById(R.id.closeTest);
        
        openTest.setOnClickListener(keypadOpenTestClick);
        
        closeTest.setOnClickListener(keypadCloseTestClick);
        
        closeKeypad.setClickable(false);
        readKeypadButton.setClickable(false);
        writeKeypadButton.setClickable(false);
        openTest.setClickable(false);
        closeTest.setClickable(false);
        
        //key value
        key1=(Button)findViewById(R.id.key1);
        key2=(Button)findViewById(R.id.key2);
        key3=(Button)findViewById(R.id.key3);
        key4=(Button)findViewById(R.id.key4);
        key5=(Button)findViewById(R.id.key5);
        key6=(Button)findViewById(R.id.key6);
        key7=(Button)findViewById(R.id.key7);
        key8=(Button)findViewById(R.id.key8);
        key9=(Button)findViewById(R.id.key9);
        key0=(Button)findViewById(R.id.key0);
        
        keyEnter=(Button)findViewById(R.id.keyEnter);
        keyCancel=(Button)findViewById(R.id.keyCancel);
        keyClear=(Button)findViewById(R.id.keyClear);
        keySpace=(Button)findViewById(R.id.keySpace);
        
        //usbkey
        usbkeyButton=(Button)findViewById(R.id.usbkeyButton);
        usbkeySN=(TextView)findViewById(R.id.usbkeySN);
        usbkeyButton.setOnClickListener(usbkeyClick);
        
        
    }
    
    public OnClickListener rfClick=new  OnClickListener(){

		@Override
		public void onClick(View v) {
			Message msg=new Message();
			msg.what=200;
			Bundle bdl = new Bundle();
			bdl.putInt("data", 1);
			
			String port="ttymxc1";
			bdl.putString("serial", port);
			msg.setData(bdl);
			try {
				msg.replyTo=mMessenger;
				mService.send(msg);
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    };
    
    public OnClickListener doorClick=new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			Message msg=new Message();
			msg.what=400;
			Bundle bdl = new Bundle();
			char pin='2';
			char[]  queryStatus={'Q',pin};
			bdl.putCharArray("data",queryStatus);
			mSystem=false;
			
			msg.setData(bdl);
			try {
				msg.replyTo=mMessenger;
				mService.send(msg);
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    	
    };
    
    public OnClickListener systemClick=new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			Message msg=new Message();
			msg.what=400;
			Bundle bdl = new Bundle();
			
			char pin='1';
			char[]  queryStatus={'Q',pin};
			bdl.putCharArray("data",queryStatus);
			mSystem=true;
			msg.setData(bdl);
			try {
				msg.replyTo=mMessenger;
				mService.send(msg);
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    	
    };
    
    public OnClickListener upsClick=new  OnClickListener(){

		@Override
		public void onClick(View v) {
			Message msg=new Message();
			msg.what=500;
			Bundle bdl = new Bundle();
			bdl.putString("data", "Q1\r");
			
			String port="ttymxc3";
			bdl.putString("serial", port);
			msg.setData(bdl);
			try {
				msg.replyTo=mMessenger;
				mService.send(msg);
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    };
    
    public OnClickListener openKeypadClick=new  OnClickListener(){

		@Override
		public void onClick(View v) {
			Message msg=new Message();
			msg.what=300;
			Bundle bdl = new Bundle();
			bdl.putString("data", "");
			bdl.putInt("function", 1);
			String port="ttymxc2";
			bdl.putString("serial", port);
			msg.setData(bdl);
			try {
				msg.replyTo=mMessenger;
				mService.send(msg);
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    };
    
    public OnClickListener closeKeypadClick=new  OnClickListener(){

		@Override
		public void onClick(View v) {
			Message msg=new Message();
			msg.what=300;
			Bundle bdl = new Bundle();
			bdl.putString("data", "");
			bdl.putInt("function", 99);
			String port="ttymxc2";
			bdl.putString("serial", port);
			msg.setData(bdl);
			try {
				msg.replyTo=mMessenger;
				mService.send(msg);
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    };
    
    public OnClickListener readKeypadClick=new  OnClickListener(){

		@Override
		public void onClick(View v) {
			Message msg=new Message();
			msg.what=300;
			Bundle bdl = new Bundle();
			bdl.putString("data", "");
			bdl.putInt("function", 2);
			String port="ttymxc2";
			bdl.putString("serial", port);
			msg.setData(bdl);
			try {
				msg.replyTo=mMessenger;
				mService.send(msg);
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    };
    
    public OnClickListener writeKeypadClick=new  OnClickListener(){

		@Override
		public void onClick(View v) {
			Message msg=new Message();
			msg.what=300;
			Bundle bdl = new Bundle();
			String terminal=writeKeypadSN.getText().toString();
			bdl.putString("data", terminal);
			bdl.putInt("function", 3);
			String port="ttymxc2";
			bdl.putString("serial", port);
			msg.setData(bdl);
			try {
				msg.replyTo=mMessenger;
				mService.send(msg);
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    };
    
    public OnClickListener keypadOpenTestClick=new  OnClickListener(){

		@Override
		public void onClick(View v) {
			Message msg=new Message();
			msg.what=300;
			Bundle bdl = new Bundle();
			bdl.putString("data", "");
			bdl.putInt("function", 4);
			String port="ttymxc2";
			bdl.putString("serial", port);
			msg.setData(bdl);
			try {
				msg.replyTo=mMessenger;
				mService.send(msg);
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			openTest.setClickable(false);
			closeTest.setClickable(true);
		}
    	
    };
    
    public OnClickListener keypadCloseTestClick=new  OnClickListener(){

		@Override
		public void onClick(View v) {
			Message msg=new Message();
			msg.what=300;
			Bundle bdl = new Bundle();
			bdl.putString("data", "");
			bdl.putInt("function", 5);
			String port="ttymxc2";
			bdl.putString("serial", port);
			msg.setData(bdl);
			try {
				msg.replyTo=mMessenger;
				mService.send(msg);
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			openTest.setClickable(true);
			closeTest.setClickable(false);
		}
    	
    };
    
    public OnClickListener usbkeyClick=new  OnClickListener(){

		@Override
		public void onClick(View v) {
			
			try {
				usbkeyButton.post(new Runnable(){
					
					public void run(){
						int iDeviceCount=0;
						try {
							iDeviceCount = ET199.Enum();
							if(iDeviceCount<1){
								usbkeySN.setText("未找到设备");
								
							}else{
								ET199 et=new ET199(0);
								byte[] atr=et.GetAtr();
								int customer=et.GetCustomer();
								int version=et.GetVersion();
								Log.d(TAG,"USBKEY atr:="+toHex(atr,atr.length));
								Log.d(TAG,"USBKEY customer:="+customer);
								Log.d(TAG,"USBKEY version:="+version);
								byte[] byID=et.GetID();
								
								Log.d(TAG,toHex(byID,byID.length));
								et.Close();
								usbkeySN.setText("COS:"+version/256+"."+String.valueOf((byte)version)+" SN:"+toHex(byID,byID.length));
								usbkeySN.setTextColor(Color.GREEN);
							}
						} catch (ET_EXCEPTION e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							usbkeySN.setText("未找到设备");
							usbkeySN.setTextColor(Color.RED);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    };

    @Override
	public void onClick(View v) {
    	char[]  ledStatus={'1','1'};
		switch (v.getId()) {
		case R.id.led1on:
			ledStatus[0]='2';
			ledStatus[1]='1';
			break;
		case R.id.led1off:
			ledStatus[0]='1';
			ledStatus[1]='1';
			break;
		case R.id.led1blink:
			ledStatus[0]='3';
			ledStatus[1]='1';
			break;
		case R.id.led2on:
			ledStatus[0]='2';
			ledStatus[1]='2';
			break;
		case R.id.led2off:
			ledStatus[0]='1';
			ledStatus[1]='2';
			break;
		case R.id.led2blink:
			ledStatus[0]='3';
			ledStatus[1]='2';
			break;
		case R.id.led3on:
			ledStatus[0]='2';
			ledStatus[1]='3';
			break;
		case R.id.led3off:
			ledStatus[0]='1';
			ledStatus[1]='3';
			break;
		case R.id.led3blink:
			ledStatus[0]='3';
			ledStatus[1]='3';
			break;
		case R.id.led4on:
			ledStatus[0]='2';
			ledStatus[1]='4';
			break;
		case R.id.led4off:
			ledStatus[0]='1';
			ledStatus[1]='4';
			break;
		case R.id.led4blink:
			ledStatus[0]='3';
			ledStatus[1]='4';
			break;
		case R.id.led5on:
			ledStatus[0]='2';
			ledStatus[1]='5';
			break;
		case R.id.led5off:
			ledStatus[0]='1';
			ledStatus[1]='5';
			break;
		case R.id.led5blink:
			ledStatus[0]='3';
			ledStatus[1]='5';
			break;
		case R.id.led6on:
			ledStatus[0]='2';
			ledStatus[1]='6';
			break;
		case R.id.led6off:
			ledStatus[0]='1';
			ledStatus[1]='6';
			break;
		case R.id.led6blink:
			ledStatus[0]='3';
			ledStatus[1]='6';
			break;

		}
		
		Message msg=new Message();
		msg.what=100;
		Bundle bdl = new Bundle();
		bdl.putCharArray("data", ledStatus);
		msg.setData(bdl);
		try {
			mService.send(msg);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

    public class IncomingHandler extends Handler{

		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
			case 200:
				String sn=msg.getData().getString("data");
				rfSN.setText(sn);
				break;
			case 300:
				int function=msg.getData().getInt("function");
				String val=msg.getData().getString("data");
				processKeypad(function,val);
				break;
			case 400:
				String doorStatus=msg.getData().getString("data");
				Log.d(TAG,"Door Status:"+doorStatus);
				
				if(!mSystem){
					if(doorStatus.equals("1")){
						checkBox3.setChecked(true);
						checkBox4.setChecked(false);
					}else{
						checkBox3.setChecked(false);
						checkBox4.setChecked(true);
					}
					
				}else{
					if(doorStatus.equals("1")){
						checkBox1.setChecked(true);
						checkBox2.setChecked(false);
					}else{
						checkBox1.setChecked(false);
						checkBox2.setChecked(true);
					}
				}
				
				
					
				//rfSN.setText(sn);
				break;
			case 500:
				String data=msg.getData().getString("data");
				if(data.length()>38){
					char powerStatus=data.charAt(38);
					if(powerStatus=='1'){
						upsStatus.setText("异常");
						upsStatus.setTextColor(Color.RED);
					}else{
						upsStatus.setText("正常");
						upsStatus.setTextColor(Color.GREEN);
					}
					String voltage=data.substring(1, 4);
					upsVoltage.setText(voltage);
				}else{
					upsStatus.setText("异常");
					upsStatus.setTextColor(Color.RED);
					upsVoltage.setText("");
				}
				break;
			default:
				super.handleMessage(msg);
			}
			
		}
    	
    }
    
    private void processKeypad(int function,String data){
    	switch(function){
    	case 1:
    		openKeypad.setClickable(false);
    		closeKeypad.setClickable(true);
            readKeypadButton.setClickable(true);
            writeKeypadButton.setClickable(true);
            openTest.setClickable(true);
            closeTest.setClickable(true);
    		break;
    	case 2:
    		readKeypadSN.setText(data);
    		writeKeypadSN.setText(data);
    		break;
    	case 3:
    		readKeypadSN.setText("");
    		break;
    	case 4:
    		Log.d(TAG,"Receive keypad value:="+data);
    		if(data.equals("31")){
    			Drawable drawable=key1.getBackground();
    			key1.setBackgroundColor(Color.RED);
    			doButtonRefersh(key1,drawable);
    			
    		}
    		if(data.equals("32")){
    			Drawable drawable=key2.getBackground();
    			key2.setBackgroundColor(Color.RED);
    			doButtonRefersh(key2,drawable);
    			
    		}
    		if(data.equals("33")){
    			Drawable drawable=key3.getBackground();
    			key3.setBackgroundColor(Color.RED);
    			doButtonRefersh(key3,drawable);
    			
    		}
    		if(data.equals("34")){
    			Drawable drawable=key4.getBackground();
    			key4.setBackgroundColor(Color.RED);
    			doButtonRefersh(key4,drawable);
    			
    		}
    		if(data.equals("35")){
    			Drawable drawable=key5.getBackground();
    			key5.setBackgroundColor(Color.RED);
    			doButtonRefersh(key5,drawable);
    			
    		}
    		if(data.equals("36")){
    			Drawable drawable=key6.getBackground();
    			key6.setBackgroundColor(Color.RED);
    			doButtonRefersh(key6,drawable);
    			
    		}
    		if(data.equals("37")){
    			Drawable drawable=key7.getBackground();
    			key7.setBackgroundColor(Color.RED);
    			doButtonRefersh(key7,drawable);
    			
    		}
    		if(data.equals("38")){
    			Drawable drawable=key8.getBackground();
    			key8.setBackgroundColor(Color.RED);
    			doButtonRefersh(key8,drawable);
    			
    		}
    		if(data.equals("39")){
    			Drawable drawable=key9.getBackground();
    			key9.setBackgroundColor(Color.RED);
    			doButtonRefersh(key9,drawable);
    			
    		}
    		if(data.equals("30")){
    			Drawable drawable=key0.getBackground();
    			key0.setBackgroundColor(Color.RED);
    			doButtonRefersh(key0,drawable);
    			
    		}
    		
    		if(data.equals("20")){
    			Drawable drawable=keySpace.getBackground();
    			keySpace.setBackgroundColor(Color.RED);
    			doButtonRefersh(keySpace,drawable);
    			
    		}
    		
    		if(data.equals("0D")){
    			Drawable drawable=keyEnter.getBackground();
    			keyEnter.setBackgroundColor(Color.RED);
    			doButtonRefersh(keyEnter,drawable);
    			
    		}
    		
    		if(data.equals("08")){
    			Drawable drawable=keyClear.getBackground();
    			keyClear.setBackgroundColor(Color.RED);
    			doButtonRefersh(keyClear,drawable);
    			
    		}
    		
    		if(data.equals("1B")){
    			Drawable drawable=keyCancel.getBackground();
    			keyCancel.setBackgroundColor(Color.RED);
    			doButtonRefersh(keyCancel,drawable);
    			
    		}
    		break;
    	case 5:
    		
    		break;
    	case 99:
    		openKeypad.setClickable(true);
    		closeKeypad.setClickable(false);
            readKeypadButton.setClickable(false);
            writeKeypadButton.setClickable(false);
            openTest.setClickable(false);
            closeTest.setClickable(false);
    		break;
    	}
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		bindService(new Intent("com.glot.gameio.usb.USBService"), mConnection, Context.BIND_AUTO_CREATE);
		mBound=true;
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		if(mBound){
			unbindService(mConnection);
			mBound=false;
		}
			
	}
	
	private void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {

		}
	}
	
	private static String digits = "0123456789abcdef";
	
	private  String toHex(byte[] data, int length) {
		if(data == null || data.length == 0 ||length<=0)
		{
			return null;
		}
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < length; i++) {
			int v = data[i] & 0xff;

			buf.append(digits.charAt(v >> 4));
			buf.append(digits.charAt(v & 0xf));
		}

		return buf.toString().toUpperCase();
	}
	
	
	protected  void  doButtonRefersh(final Button button,final Drawable d){
		button.post(new Runnable(){
			public void run(){
				sleep(200);
				button.setBackgroundDrawable(d);
			}
		});
	}

    
    
}
