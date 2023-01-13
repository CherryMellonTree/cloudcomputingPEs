# addTransaction
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <addTransaction xmlns="http://tempuri.org/">
            <price>63</price>
            <payer>Charles</payer>
            <debtors>
                <string xmlns="http://schemas.microsoft.com/2003/10/Serialization/Arrays">Harry</string>
                <string xmlns="http://schemas.microsoft.com/2003/10/Serialization/Arrays">Carl</string>
            </debtors>
        </addTransaction>
    </Body>
</Envelope>

# Pay

<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <pay xmlns="http://tempuri.org/">
            <payment>21</payment>
            <payer>Carl</payer>
            <payee>Charles</payee>
        </pay>
    </Body>
</Envelope>

# personalBalance

<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <personBalance xmlns="http://tempuri.org/">
            <uid>Harry</uid>
        </personBalance>
    </Body>
</Envelope>