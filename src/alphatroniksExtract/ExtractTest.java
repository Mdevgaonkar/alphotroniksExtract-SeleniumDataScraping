package alphatroniksExtract;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExtractTest {

	static String[] productlinks = {
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-Mild-Steel-Nuts/pid_40227369/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-Short-Female-Banana-Socket-does-Not-Have-Holes-For-Inserting-Wires-/pid_36255931/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-Threaded-Rod/pid_40227399/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-X-10-Mm-Screw/pid_40227375/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-X-12-Mm-Screw/pid_40227377/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-X-15-Mm-Screw/pid_40227379/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-X-20-Mm-Screw/pid_40227381/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-X-25mm-Screw/pid_40227383/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-X-30mm-Screw/pid_40227385/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-X-40mm-Screw/pid_40227387/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-X-50mm-Screw/pid_40227389/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-X-60mm-Screw/pid_40227391/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-X-6mm-Screw/pid_40227371/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-X-70mm-Screw/pid_40227393/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-X-8-Mm-Screw/pid_40227373/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-X-80mm-Screw/pid_40227395/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4mm-X-90mm-Screw/pid_40227397/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4x3-Keypad/pid_36113389/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4x3-Keypad/pid_38679609/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4x4-Keypad/pid_36113385/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/4x4-Keypad/pid_38679607/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/5-K-Trimmer/pid_38464341/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/5-Kgcm-Torque-5mm-Shaft-Sanyo-Denki-Original-Japanese-Unipolar-Stepper-Motor-For-CNCRobotic-ArmAutomation-Projects/pid_103908511/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/5-Pcs-Ams1117-33V-1A-Voltage-Regulator-Sot223/pid_103087559/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/5-Pin-Joystick-Module/pid_36113461/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/50-K-Trimmer/pid_38464337/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/50-Teeth-Spur-Gear-For-6mm-Motor-Shaft/pid_88676367/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/500/pid_36460461/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/500-K-Trimmer/pid_38464329/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/500-Ohm-Trimmer/pid_38464321/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/500-RPM-Gear-Motor/pid_39543573/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/500K/pid_36460641/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/50K/pid_36460629/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/555-PWM-DC-Motor-Speed-Control-Module/pid_38791745/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/555-Timer-IC/pid_40227413/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/56-Kilo-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338485/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/56-Kilo-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338495/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/56-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338479/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/560-Kilo-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338499/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/560-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338481/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/5AMP-PVC-TERMINAL-Heavy-Duty/pid_36255595/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/5k/pid_36460469/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/5mm-Threaded-Rod/pid_40227401/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/5V1AMP-ADAPTOR/pid_36113613/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/5V1AMP-ADAPTOR/pid_38648205/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/5V1AMP-ADAPTOR/pid_38679757/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/5V2AMP-ADAPTOR/pid_36113627/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/5V2AMP-ADAPTOR/pid_38648215/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/5V2AMP-ADAPTOR/pid_38679767/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/6-7-SEGMENT-LED-Display-PCB/pid_36113581/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/6-7-SEGMENT-LED-Display-PCB/pid_38679737/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/6-PENCIL-AA-CELL-HOLDER/pid_38679755/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/6-PIN-BOX-HEADER/pid_36255577/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/6-PIN-BOX-HEADER/pid_38463675/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/60-RPM-Gear-Motor/pid_39543563/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/63mm-Female-To-35-Mm-Male-Stereo-Pin-Converter/pid_81707943/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/63mm-Female-To-35-Mm-Male-Stereo-Pin-Converter-Low-Cost/pid_81708139/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/68-Kilo-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338507/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/68-Kilo-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338509/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/68-Mega-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338523/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/68-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338501/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/680-Kilo-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338513/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/680-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338503/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/6mm-Shaft-Dummy-Axle-Freewheel/pid_39622011/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/6MMX200MM-AXLE/pid_36113559/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/6MMX200MM-AXLE/pid_38679723/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/6V1AMP-ADAPTOR/pid_36113615/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/6V1AMP-ADAPTOR/pid_38648207/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/6V1AMP-ADAPTOR/pid_38679759/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/7-Cm-X-2-Cm-Wheel-For-6mm-Shaft/pid_39978989/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/7-RPM-Gear-Motor/pid_39543555/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/7-Strand-X-4-Core-Ribbon-Wire/pid_39622025/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/74HC595-8Bit-Shift-Register-For-ArduinoMicrocontroller/pid_61492691/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/75V1AMP-ADAPTOR/pid_36113617/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/75V1AMP-ADAPTOR/pid_38648209/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/75V1AMP-ADAPTOR/pid_38679761/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/7805-Step-Down-Voltage-Regulator-IC/pid_89244449/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/8-Channel-Opto-Relay-Module-5Volt/pid_38679599/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/8-DIP-Switch/pid_40227451/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/8-Relay-PCB/pid_38679665/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/82-Kilo-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338537/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/82-Kilo-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338539/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/82-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338531/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/820-Kilo-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338545/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/820-Ohm-14-Watt-Carbon-Film-Resistors-100-Pc-Pack/pid_53338533/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/89C51-Microcontroller-IC/pid_40227461/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/8mm-Threaded-Rod/pid_40227403/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/9-Volt-Battery-Snap/pid_40227457/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/9-Volt-Cell/pid_40227455/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/9V1AMP-ADAPTOR/pid_36113621/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/9V1AMP-ADAPTOR/pid_38648211/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/9V1AMP-ADAPTOR/pid_38679763/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/9V2AMP-ADAPTOR/pid_36113629/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/9V2AMP-ADAPTOR/pid_38648217/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/9V2AMP-ADAPTOR/pid_38679769/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ADC0804-Analog-To-Digital-Converter-IC/pid_40227411/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ADC0808-Analog-To-Digital-Converter-IC/pid_40227409/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Adhesive-GoPro-SJCAM-Flat-And-Curved-Mount-1-Pair/pid_63587565/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ADXL-335-Accelerometer-Module/pid_36113399/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ADXL-335-Accelerometer-Module/pid_38679617/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ADXL345-Accelerometer/pid_36113491/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ADXL345-Accelerometer/pid_38679677/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/AIRCRAFT-STYLE-TOGGLE-SWITCH/pid_38679733/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Alcohol-Sensor-Module/pid_36113457/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Alcohol-Sensor-Module/pid_38679655/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Arduino-Ethernet-Shield/pid_60877465/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Arduino-Mega/pid_38679621/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Arduino-Nano-With-USB-Cable/pid_36255847/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Arduino-Pro-Mini-5-Volt/pid_38679623/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Arduino-Uno-Prototyping-Shield/pid_44717037/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Arduino-UNO-R3/pid_38679597/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ARM7-LPC2148-DEVELOPMENT-BOARD/pid_91364715/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Assorted-Jumper-Wire-Set-For-BreadboardArduinoSensorsetc-10-Pc-Each/pid_88676373/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ATMega-328PPU-Microcontroller-Icwithout-Boot-Loader/pid_40227459/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ATMEGA16A-Programmable-Microcontroller-IC/pid_89261807/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Basic-Level-1-Robot-Chassis-Black/pid_39622021/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/BC548-Small-Signal-General-Purpose-NPN-Transistor-Pack-Of-5-Pc/pid_103087043/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/BC557-Small-Signal-PNP-Transistor-5-Pc-Pack/pid_103087039/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/BD139-Medium-Power-15-Amp-NPN-Transistor-5-Pc-Pack/pid_103087557/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Big-BO-Motor-Wheel/pid_39978991/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Big-Castor-Wheel/pid_39622015/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Big-Rocker-Switch-With-Light-230-V/pid_38483805/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Bipolar-5mm-Shaft-Stepper-Motor-17HA0403-32N/pid_39978965/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Blue-5mm-LED/pid_40227435/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/BNC-To-SMA-Adapter/pid_86187855/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/BOTH-SIDE-MALE-BERG-HEADER/pid_38463621/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Breadboard-An-Electronics-Enthusiasts-First-Tool/pid_85408175/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Bridge-Rectifier-Kit/pid_40227333/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Buckle-Mount-For-SJCAM-GoPro-Action-Camera-1-Pc-Pack/pid_63585771/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Budget-Soldering-Iron-230-Volt-25-Watt/pid_61492473/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Car-Cigarette-Lighter-Socket-Useful-For-Giving-Power-To-Extra-Mobile-Charger-Laptop-Charger-Or-Electrical-Accessories-In-Car-Passengers-Back-Seat/pid_36255907/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Car-Male-Cigarette-Lighter-Plug-useful-For-Taking-Power-From-Cars-12-Volt-Power-Outlet/pid_36255909/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Centre-Off-Slide-DPDT-Switch-Big/pid_38648167/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Centre-Off-Small-DPDT-Rocker-Switch/pid_38483813/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Charger-Doctor-USB-VOLTMETERAMMETER-FOR-TESTING-USB-CHARGERS/pid_36113563/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Charger-Doctor-USB-VOLTMETERAMMETER-FOR-TESTING-USB-CHARGERS/pid_38679725/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Coin-Cell-Holder-Horizontal-PCB-Mounting/pid_36255913/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Coin-Cell-Holder-Vertical-PCB-Mounting/pid_36255911/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/COLOUR-SENSOR-TCS-230/pid_38679735/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/COLOUR-SENSOR-TCS-3200/pid_36113577/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/CORDLESS-PHONE-BATTERY-CONNECTOR/pid_38463631/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/CP2102-USB-To-TTL-Converter-Module/pid_36113451/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/CP2102-USB-To-TTL-Converter-Module/pid_38679651/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DB25-PCB-MOUNT-FEMALE/pid_36255519/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DB25-PCB-MOUNT-FEMALE/pid_38463617/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DB25-PCB-Mount-Male/pid_36255521/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DB25-PCB-Mount-Male/pid_38463619/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DC-DC-Micro-Boost-Module/pid_38679675/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DCDC-Step-Up-Boost-4A-XL6009/pid_39622289/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DHT11-DIGITAL-TEMPERATURE-SENSOR-MODULE/pid_36113557/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DHT11-DIGITAL-TEMPERATURE-SENSOR-MODULE/pid_38679721/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DHT11-Humidity-And-Temperature-Sensor/pid_36113439/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DHT11-Humidity-And-Temperature-Sensor/pid_38679643/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Dotted-PCB-15-X-1-Inch/pid_38314979/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Dotted-PCB-2-X-15-Inch/pid_38314977/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Dotted-PCB-3-X-1-Inch/pid_38314975/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Dotted-PCB-3-X-2-Inch/pid_38314973/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Dotted-PCB-4-X-2-Inch/pid_38314969/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Dotted-PCB-4-X-4-Inch/pid_38314967/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Dotted-PCB-4-X-6-Inch/pid_38314965/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Dotted-PCB-4-X-8-Inch/pid_38314963/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Dotted-PCB-6-X-2-Inch/pid_38314959/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Double-Sided-FR4-Copper-Clad-PCB-Board-12-Inch-X-12-Inch/pid_53337797/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DPDT-ON-OFF-Rocker-Switch/pid_36435921/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DPDT-Switch/pid_39622023/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DPDT-Toggle-Switch/pid_36435787/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DPDT-Toggle-Switch/pid_38648177/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DPST-Toggle-Switch/pid_36435935/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Ds3231-Rtc-Clock-Module/pid_36113527/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Ds3231-Rtc-Clock-Module/pid_38679701/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DTMF-Module/pid_36113539/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DTMF-Module/pid_38679709/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Dual-Shaft-75-RPM-BO-Motor-12-Volt/pid_93463805/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DUAL-USB-A-TYPE-PCB-MOUNT-SOCKET/pid_36255535/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/DUAL-USB-A-TYPE-PCB-MOUNT-SOCKET/pid_38463633/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/EM-18-RFID-READER-MODULE/pid_36113565/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/EM-18-RFID-READER-MODULE/pid_38679727/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/EM-18-RFID-Reader-Module-With-TTL-Output/pid_39622009/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ESP-12E-WiFi-Module/pid_101885843/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ESP-13-WiFi-Shield-For-Arduino-Uno-IOT-Projects/pid_102304557/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ESP-8266-01-Wifi-Module/pid_38679705/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ESP8266-NodeMcu-WiFi-Development-Board/pid_101885319/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/FEMALE-BERG-STRIPHEADER/pid_36255537/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Female-DC-Jack-With-Sleeve/pid_36255921/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Female-DC-Plug-With-Screw-Terminals-Makes-It-Solderless-/pid_36255925/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Ferric-Chloride-PCB-Etching-Powder/pid_39622005/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Fingerprint-Scanner-Module/pid_39620181/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Fingerprint-Scanner-Module-For-Electronic-Security-System-Based-Projects/pid_93144409/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Fingerprint-Scanner-Module-R305/pid_39622007/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Flame-Sensor-Module/pid_93729685/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/FLAT-2-CELL-HOLDER-WITH-SNAP-STUDS/pid_38679747/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Gas-Sensor-Module/pid_36113455/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Gas-Sensor-Module/pid_38679653/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/GAS-SENSOR-SOCKET/pid_36255575/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/GAS-SENSOR-SOCKET/pid_38463673/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Glue-Gun/pid_36113645/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Glue-Gun/pid_38679779/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Graphical-LCD-128-X-64/pid_39978975/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Green-5mm-LED/pid_40227437/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Handlebar-Mounted-USB-Phone-Charger-For-Motorcycles/pid_96173091/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Hard-Glue-Sticks/pid_36113523/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Hard-Glue-Sticks/pid_38679699/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/HC-SR-04-Ultrasonic-Distance-Sensor/pid_36113411/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/HC-SR-04-Ultrasonic-Distance-Sensor/pid_38679625/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/HC05-Bluetooth-Module/pid_38679649/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/HP-Brand-High-Performance-Air-Filter-For-Motorcycles/pid_96173085/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/I2C-Module-For-LCD/pid_103854329/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/INA128P-Precision-Low-Power-INSTRUMENTATION-AMPLIFIERS/pid_86494873/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Infra-Red-LEDBlue/pid_40227427/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Infra-Red-SensorBlack/pid_40227429/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/IRF540-MOSFET-3-Pc-Pack/pid_51631653/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/IRFZ44N-MOSFET-N-Channel-3-Pc-Pack/pid_51817077/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Johnson-Original-Gear-DC-Motor/pid_39978979/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Johnson-Side-Shaft-600-RPM-DC-Gear-Motor-For-Shaker-Table-Robotic-Projects/pid_103906381/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/L293D-Motor-Driver-IC/pid_40227405/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/L293D-Motor-Driver-Module/pid_38679647/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/L293D-Motor-Driver-Shield/pid_38679629/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/L298-Motor-Driver-IC/pid_40227407/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/L298-Motor-Driver-Module/pid_36113441/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Laser-Diode/pid_36113503/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Laser-Diode/pid_38679685/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Laser-Security-Alarm-Kit-soldering-Required/pid_39978997/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Level-1-Robot-Car-Kit-10-Sets-Bundle-Pack-Great-For-Collegeschool-Workshops/pid_88676375/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/LF356N-OpAmp-IC/pid_86493859/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Line-Follower-Sensor-Module/pid_36113433/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Line-Follower-Sensor-Module/pid_38679639/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Lithium-Charger-Module-With-Micro-USB-Socket/pid_36113463/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Lithium-Charging-Module-With-LOW-VOLTAGE-CUTOFF/pid_36113551/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Lithium-Charging-Module-With-LOW-VOLTAGE-CUTOFF/pid_38679717/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Lithium-Charging-Module-With-Micro-USB-Socket/pid_38679659/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/LM2596-Buck-Converter-Module/pid_39622261/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/LM386-Audio-Amplifier-IC/pid_40227417/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/LM741-OpAmp-IC/pid_40227415/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MadBike-Brand-Full-Finger-Gloves-With-Steel-Knuckle-Guards/pid_96172915/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Male-55mm-DC-Jack/pid_36255915/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MALE-BERG-STRIP-90-DEGREE/pid_38463623/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MALE-BERG-STRIPHEADER/pid_38463637/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Male-DC-Plug-With-Screw-Terminals-Makes-It-Solderless-/pid_36255923/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MAX7219-DOT-MATRIX-LED-DISPLAY-MODULE-For-ARDUINO-PROJECTS/pid_92595491/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MCT2E-Opto-Coupler-IC/pid_40227421/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MG995-METAL-GEAR-SERVO/pid_38679713/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MG996R-METAL-GEAR-SERVO/pid_36113549/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Micro-Limit-Switch-MLS20/pid_36435893/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Micro-SD-Card-Reader-Module-For-Arduino-Based-Projects/pid_91364797/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MICRO-USB-FEMALE-PCB-MOUNT/pid_36255549/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MICRO-USB-FEMALE-PCB-MOUNT/pid_38463647/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MICRO-USB-MALE-WITH-DUST-CAP/pid_36255561/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MICRO-USB-MALE-WITH-DUST-CAP/pid_38463659/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Mifare-1356-Mhz-RFID-Reader-Module-MFRC522/pid_39978993/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MINI-0-999-Volt-Digital-Voltmeter/pid_36113497/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MINI-0-999-Volt-Digital-Voltmeter/pid_38679681/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MINI-0499-Amp-Digital-DC-Ammeter/pid_36113485/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MINI-0499-Amp-Digital-DC-Ammeter/pid_38679673/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MINI-USB-FEMALE-PCB-MOUNT/pid_36255557/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MINI-USB-FEMALE-PCB-MOUNT/pid_38463655/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MINI-USB-MALE-With-Cover/pid_36255545/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MINI-USB-MALE-With-Cover/pid_38463643/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Mirror-Mounted-5-Volt-Output-USB-Phone-Charger-For-Motorcycles/pid_96173089/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MobileCellphone-Vibrator-Motor-15-Volt-DC/pid_102303903/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MOC7811-Photo-Interrupt-slot-Sensor/pid_40227423/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Motorcycle-Handle-Saver/pid_96172997/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Motorcycle-Switch-For-LED-Fog-LightsBlinkersKill-Switch/pid_96173077/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MOXI-Brand-High-Performance-Air-Filter-For-Motorcycles/pid_96173093/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MPU1-SWITCH/pid_36113553/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MPU6050-3-Axis-Accelerometer-And-Gyro/pid_36113505/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MPU6050-3-Axis-Accelerometer-And-Gyro/pid_38679687/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MQ135-Air-Quality-Sensor-For-Arduino-Microcontroller-Based-Projects/pid_91364799/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MQ4-Methane-Gas-Natural-Gas-Sensor-Module/pid_88775443/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MS1-Magnetic-Switch/pid_38679667/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Multicolour-5mm-LED/pid_40227445/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/MX-1010-Universal-Pin-Converter-Ideal-For-Homeoffice-Use-And-Travellers/pid_40227325/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Neodymium-Disc-Magnet-30mm-X-6mm-30-Mm-Diameter-6mm-Thickness-Pack-Of-10-Pcs/pid_53331201/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/NONormally-Open-Reed-Switch/pid_36435879/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/NPN-Small-Signal-Transistor-BC547-Pack-Of-5-Pcs/pid_88676371/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/NRF24L01-24-Ghz-RF-Transceiver/pid_36113537/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/NRF24L01-24-Ghz-RF-Transceiver/pid_38679707/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Original-FT232RLFTDIUSBtoTTLSerialAdapterModuleforArduinoMiniPort33V5V/pid_86138455/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PAM8403-5-Volt-3-Watt-Stereo-Amplifier-Module/pid_36113481/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PAM8406-5-Watt-Amplifier-Module/pid_41766363/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Panel-Mounting-Female-55mm-DC-Jack-With-Mounting-Flange/pid_36255919/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-Etching-Powder/pid_39543651/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-Hand-Drill-Tool/pid_38679689/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-Mount-12-Volt-DPDT-Relay/pid_85736155/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-Mount-12-Volt-SPDT-Sugar-Cube-Relay/pid_85736171/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-Mount-24-Volt-SPDT-Sugar-Cube-Relay/pid_85736181/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-Mount-5-Volt-DPDT-Relay/pid_85736145/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-Mount-5-Volt-SPDT-Sugar-Cube-Relay/pid_85736157/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-Mount-6-Volt-SPDT-Sugar-Cube-Relay/pid_85736165/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-Mount-9-Volt-SPDT-Sugar-Cube-Relay/pid_85736169/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-MOUNT-FEMALE-DB9-CONNECTOR/pid_36255583/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-MOUNT-FEMALE-DB9-CONNECTOR/pid_38463681/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-MOUNT-MALE-DB9-CONNECTOR/pid_36255585/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-MOUNT-MALE-DB9-CONNECTOR/pid_38463683/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-Mounting-4mm-Female-DC-Jack-also-Known-As-Nokia-Thick-Pin-Socket-As-It-Was-Popularly-Used-In-First-Generation-Nokia-Phones/pid_36255935/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-Mounting-Female-55mm-DC-Jack/pid_36255917/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PCB-Mounting-SPDT-Slide-Switch/pid_38648189/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Peltier-12706/pid_36113431/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Peltier-12706/pid_38679637/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Photo-Diode/pid_40227431/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Pink-5mm-LED/pid_40227443/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PIR-Sensor/pid_38679627/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Premium-Quality-35mm-Stereo-Male-Audio-Pin-Metal-Body/pid_44881045/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Pulse-Sensor-Module/pid_44924015/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Push-ONOFF-Switch-10A250VAC/pid_38648201/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Push-ONOFF-Switch-1A250VAC/pid_38483797/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Push-To-ON-Momentary-Switch-Big-Plastic-Body/pid_103906467/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Push-To-ON-Push-To-OFF-Switch-Big-Plastic-Body/pid_38648171/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Push-To-ON-Switch-Small-Metal-Body/pid_38648169/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/PWM-DC-Motor-Speed-Control-Kit-Using-555-Timer-IC-6-Volt-To-12-Volt-Power-Supply-Required-To-Run-This-Kit/pid_40227335/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Raspberry-Pi-3-Model-B-With-WiFi-And-Bluetooth/pid_43511027/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Red-5mm-LED/pid_40227433/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/RED-Gear-Shifter-Shoe-Protector/pid_97325683/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/RED-LED-Brake-Light-Bulb-For-Motorcycles-With-Flashing-Function-12-Volt/pid_96173025/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/RF-24GHZ-MULTI-CHANNEL-REMOTE-FOR-2-DC-MOTORS20A-DRIVE/pid_44355713/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/RFID-Tags-125-Khz/pid_39978977/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/RJ45-FEMALE-PCB-MOUNT-CONNECTOR-WITH-SHEILD/pid_36255555/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/RJ45-FEMALE-PCB-MOUNT-CONNECTOR-WITH-SHEILD/pid_38463653/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/RJ45-FEMALE-PCB-MOUNT-CONNECTOR-WITHOUT-SHEILD/pid_36255553/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/RJ45-FEMALE-PCB-MOUNT-CONNECTOR-WITHOUT-SHEILD/pid_38463651/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Robot-Chassis-For-4-Motors-With-Castor-Clamp/pid_39622013/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Rocket-Brand-12-Volt-7-Ah-Sealed-Maintainance-Free-Battery-At-Low-CostLimited-Stock/pid_86008759/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ROTARY-ENCODER-WITH-KNOB/pid_36113583/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ROUND-FEMALE-BERG-STRIP/pid_38463625/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Samsung-37-Volt-2600mAh-18650-Size-Lithium-Ion-Cell/pid_38679679/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/SD-Card-Module-For-Arduino-Based-Projects/pid_91364795/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/SG90-Servo/pid_38679641/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/SIM-900-GSM-Module/pid_39978967/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/SINGLE-PENCIL-AA-CELL-HOLDER/pid_38679745/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Single-Strand-Wire-22-Gauge-5-Metre-Pack/pid_60544799/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Sliding-SPST-Toggle-Switch/pid_36435915/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Slim-1-Way-Rocker-Switch/pid_38648179/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Slim-2-Way-Rocker-Switch/pid_38483807/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/SMA-Connector/pid_53337825/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Small-4-Pin-Tact-Switch/pid_38483791/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Small-Castor-Wheel/pid_39622017/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Small-Push-To-OFF-Metal-Body-Switch/pid_36435857/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Small-Rocker-1-Way-Switch/pid_36435775/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Small-Rocker-Switch-With-Light230V/pid_38483775/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Small-SPDT-Rocker-Switch/pid_38483783/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Small-SPDT-Slide-Switch/pid_36435847/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Soft-Glue-Sticks/pid_36113521/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Soft-Glue-Sticks/pid_38679697/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Soil-Sensor/pid_36113393/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Soil-Sensor/pid_38679613/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/SOLDER-PASTE-FLUX/pid_38679741/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/SOLDER-WIRE/pid_36113589/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/SOLDERING-STAND/pid_36113641/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/SOLDERING-STAND/pid_38679777/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Soldron-12-Volt-25-Watt-Soldering-Iron/pid_103087047/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Soldron-25-WATT-SOLDERING-IRON/pid_36113635/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Soldron-938-Digital-Temperature-Controlled-Soldering-Station/pid_42635527/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Soldron-Micro-Soldering-Station/pid_42635585/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Sound-Sensor/pid_36113391/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Sound-Sensor/pid_38679611/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/SP200-Programmer/pid_93763151/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/SPDT-Toggle-Switch/pid_36435799/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Super-Hard-Black-Glue-Stick-1-Pc-Pack/pid_41578065/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/TCRT5000-IR-Sensor-For-Line-Follower-Robot-Arduino-Projects/pid_91364615/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/TDA2030-Audio-Amplifier-IC/pid_40227419/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Temperature-Controlled-Thermostat-Based-Glue-Gun-230-Volt-120Watt-10-Pcs-Glue-Sticks/pid_93712593/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Temperature-Sensor-Module/pid_36113479/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Temperature-Sensor-Module/pid_38679669/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Threaded-Panel-Mount-DC-Jack/pid_36255927/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Threaded-Panel-Mounting-Female-2mm-DC-Jack/pid_36255937/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/TIP122-NPN-DARLINGTON-SILICON-POWER-TRANSISTOR-3-Pc-Pack/pid_51859493/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Triac-Based-230-Volt-AC-Fan-SpeedBulb-Brightness-Controller-Kit/pid_42646651/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/TSOP1738-Infra-Red-Receiver-IC/pid_40227425/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/UBlox-NEO-6M-GPS-MODULE/pid_89478849/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/ULN2003-Darlington-Transistor-Driver-Array-IC-3-PC-Pack/pid_52387511/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Ultra-Voilet-5mm-LED/pid_40227447/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/USB-A-FEMALE-PCB-MOUNT/pid_36255563/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/USB-A-FEMALE-PCB-MOUNT/pid_38463661/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/USB-A-FEMALE-PCB-MOUNT-Straight/pid_36255547/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/USB-A-FEMALE-PCB-MOUNT-Straight/pid_38463645/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/USB-A-FEMALE-WITH-DUSTCAP/pid_36255579/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/USB-A-FEMALE-WITH-DUSTCAP/pid_38463677/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/USB-A-MALE-PCB-MOUNT/pid_36255559/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/USB-A-MALE-PCB-MOUNT/pid_38463657/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/USB-A-MALE-WITH-DUSTCAP/pid_36255541/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/USB-A-MALE-WITH-DUSTCAP/pid_38463639/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/USB-ASP-IC-Programmer-For-AVR-Family-Ics/pid_38679703/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/USB-B-TYPE-FEMALE-PCB-MOUNT/pid_36255551/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/USB-B-TYPE-FEMALE-PCB-MOUNT/pid_38463649/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Vibration-Sensor/pid_36113403/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Vibration-Sensor/pid_38679619/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/VOLTMETERAMMETER-MODULE/pid_36113569/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Water-Pump/pid_38304901/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Water-Rain-Sensor-Module/pid_36113397/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Water-Rain-Sensor-Module/pid_38679615/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/White-5mm-LED/pid_40227441/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Wire-Cutter-Multitec-07/pid_38679693/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Wire-Stripper-Multitec-150B/pid_38679691/index.html",
		"file:///Users/Mayur/Downloads/www.alphatroniks.com/Yellow-5mm-LED/pid_40227439/index.html",
		};
	static WebDriver driver;
	static ExcelSheet instruEntry;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String xyz = "3.5";
//		String pqr = "3";
//		int abc = Integer.valueOf((int) Math.ceil(Double.valueOf(xyz)));
//		int def = Integer.valueOf((int) Math.ceil(Double.valueOf(pqr)));
//		System.out.println(abc);
//		System.out.println(def);
		try {
			
		
		//Create Blank workbook
		instruEntry = new ExcelSheet();
		instruEntry.writeHeaders();
		
		
		// Optional, if not specified, WebDriver will search your path for chromedriver.
		  System.setProperty("webdriver.chrome.driver", "/Users/Mayur/Documents/eclipse/Eclipse projects/Selenium/webdriver/chromedriver");

		  driver = new ChromeDriver();
//		  driver.get("file:///Users/Mayur/Downloads/www.alphatroniks.com/Arduino-UNO-R3/pid_38679597/index.html");
		  int rowIndex = 1;
		  for (String link : productlinks) {
			  driver.get(link);
			  Thread.sleep(2000);  // Let the user actually see something!
			  Instrument instrument = new Instrument();
			  instrument = scrapeInstrumentData(driver);
			  
			  writeRowInExcelSheet(instruEntry,instrument, rowIndex);
			  rowIndex++;
			  System.out.println(link);
			  System.out.println();
		}
		  
		  
		  driver.quit(); 
//		  Thread.sleep(2000);  // Let the user actually see something!

		  instruEntry.createFile("instruEntryBook.xlsx");
		  
		} catch (Exception e) {
			// TODO: handle exception
			driver.quit(); 
//			  Thread.sleep(2000);  // Let the user actually see something!

			  try {
				instruEntry.createFile("instruEntryBook.xlsx");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
	private static void writeRowInExcelSheet(ExcelSheet instruEntry,
			Instrument instrument, int rowIndex) {
		// TODO Auto-generated method stub
//		{"instrumentName","instrumentSubtitle", "description","mrp","sellingPrice","type","photoFile"}
//			0				1						2			3		4			5		6
		instruEntry.writeRow(rowIndex);
		
		instruEntry.writeCell(0, instrument.getInstrumentName());
		instruEntry.writeCell(1, instrument.getInstrumentSubtitle());
		instruEntry.writeCell(2, instrument.getDescription());
		instruEntry.writeCell(3, instrument.getMrp());
		instruEntry.writeCell(4, instrument.getSellingPrice());
		instruEntry.writeCell(5, instrument.getType());
		instruEntry.writeCell(6, instrument.getphotoFile());
		instruEntry.writeCell(7, getInstumentJSONString(instrument));
		
		
	}

	public static Instrument scrapeInstrumentData(WebDriver driver) throws InterruptedException {
		Instrument instruObj = new Instrument();
		  
		  instruObj.setInstrumentName(extractName(driver));
		  instruObj.setInstrumentSubtitle(extractSubTitle(driver));
		  instruObj.setMrp(extractMRP(driver));
		  instruObj.setSellingPrice(extractSP(driver));
		  instruObj.setDescription(extractDescription(driver));
		  instruObj.setType(extractType(driver));
		  Thread.sleep(2000);
		  instruObj.setphotoFile(extractPhotoUrl(driver));
		 
		  return instruObj;
	}
	
	public static String extractName(WebDriver driver){
		String instrumentName = "";
		if(driver.findElements(By.className("productText")).size() > 0){
		WebElement productName = driver.findElement(By.className("productText"));
		instrumentName = productName.getText();
//		System.out.println(instrumentName);
		}else {
			instrumentName = "NoName";
		}
		return instrumentName;
	}
	
	public static String extractSubTitle(WebDriver driver){
		String subtitle = "";
		List<WebElement> elements = driver.findElements(By.className("blk-nm"));    

		for(WebElement ele : elements){
			String eleText = ele.getText();
		    if( !eleText.equals("Home")){
		    	subtitle = ele.getText() ;
		    }
		} 
		
//		System.out.println(subtitle);
		return subtitle;
	}
	
	public static int extractMRP(WebDriver driver){
		int instrumentMRP = 0;
		if(driver.findElements(By.className("noRsTx")).size() > 0){
		WebElement productMRP = driver.findElement(By.className("noRsTx"));
		instrumentMRP = Integer.valueOf((int) Math.ceil(Double.valueOf(productMRP.getText())));
//		System.out.println(instrumentMRP);
		}else{
			instrumentMRP=0;
		}
		return instrumentMRP;
		
	}
	
	public static int extractSP(WebDriver driver){
		int instrumentSP = 0;
		if(driver.findElements(By.className("RsTx")).size() > 0){
		WebElement productSP = driver.findElement(By.className("RsTx"));
//		instrumentSP =Integer.valueOf(productSP.getText());
		instrumentSP = Integer.valueOf((int) Math.ceil(Double.valueOf(productSP.getText())));
//		System.out.println(instrumentSP);
		}else{
			instrumentSP=0;
		}
		return instrumentSP;
	}
	
	public static String extractDescription(WebDriver driver){
		String description="";
		  
		  if(driver.findElements(By.className("subtx")).size() > 0){
		  WebElement productDescription = driver.findElement(By.className("subtx"));
		  description = description+productDescription.getAttribute("innerHTML");
		  }
		  
		  if(driver.findElements(By.className("sub-bx")).size() > 0){
		  WebElement productDescription = driver.findElement(By.className("sub-bx"));
		  String specs = productDescription.getAttribute("innerHTML");
		  specs = specs.trim().replaceAll(" +", " ");
		  specs = specs.replaceAll("[\r\n]+", " ");
		  specs = specs.replaceAll("</span>  <span class=\"cellB\">", "&nbsp;-&nbsp;</span><span class=\"cellB\">");
		  specs = specs.replaceAll("</span>   <span class=\"row\">", "</span><br><span class=\"row\">");
		  description = description+"<br><strong>Specifications</strong><br>"+specs;
		  }
//		  System.out.println(description);
		  return description;
	}
	
	public static String extractType(WebDriver driver){
		String type = "";
		List<WebElement> elements = driver.findElements(By.className("blk-nm"));    

		for(WebElement ele : elements){
			String eleText = ele.getText();
		    if( !eleText.equals("Home")){
		    	type = type +ele.getText()+ "," ;
		    }
		} 
		type = type.substring(0, type.length()-1);
//		System.out.println(type);
		return type;
	}
	
	public static String extractPhotoUrl(WebDriver driver){
		String photoUrl="";
//		
		if(driver.findElements(By.className("zoomWindow")).size() > 0){
		WebElement productPhoto = driver.findElement(By.className("zoomWindow"));
		String attributeValue = productPhoto.getAttribute("style");
		ArrayList<String> links = pullLinks(attributeValue);
		
		if(links.size() >0){
			photoUrl = links.get(0);	
		}
		
		}else if(driver.findElements(By.className("classzoomimage")).size() > 0){
			WebElement productPhoto = driver.findElement(By.className("classzoomimage"));
			String attributeValue = productPhoto.getAttribute("src");
			photoUrl = attributeValue;
		}
		
//		System.out.println(links.get(0));
		return photoUrl;
	}
	
	//Pull all links from the body for easy retrieval
	public static ArrayList<String> pullLinks(String text) {
		ArrayList<String> links = new ArrayList<String>();

		String regex = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&amp;@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&amp;@#/%=~_()|]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while(m.find()) {
			String urlStr = m.group();
			if (urlStr.startsWith("(") && urlStr.endsWith(")"))
			{
				urlStr = urlStr.substring(1, urlStr.length() - 1);
			}
			links.add(urlStr);
		}
		return links;
	}

	public static String getInstumentJSONString(Instrument instrument) {
		String instumentJSONString="";
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String instrumentJson = gson.toJson(instrument);
//		System.out.println(instrumentJson);
		
		JsonParser parser = new JsonParser(); 
		JsonObject instruJSONObj = (JsonObject) parser.parse(instrumentJson);
		instruJSONObj.remove("mrp");
		instruJSONObj.remove("sellingPrice");
		
		instrumentJson = gson.toJson(instruJSONObj);
//		System.out.println(instrumentJson);
		instumentJSONString = instrumentJson;
		return instumentJSONString;
		
	}
	

}
