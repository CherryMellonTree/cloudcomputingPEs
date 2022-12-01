///IMPORTS
const axios = require('axios').default;
const chalk = require('chalk');
const yargs = require('yargs');
const log = require('simple-node-logger').createSimpleLogger('requests.log');
yargs.version('1.1.0');
///api call functions
async function getMultipleUserNames(value){
    const response = await axios.get(`https://randomuser.me/api/?results=${value}`).then(log.info(`https://randomuser.me/api/?results=${value}`));
    const returnvalue = response.data;
    let returnstring = ""
    let i = 0;
    while(i<((returnvalue["results"].length))){
        returnstring += JSON.stringify((returnvalue["results"][i]["name"]));
        returnstring += "\n";
        i++;
    }
    return returnstring;
}
async function getFemaleUser(value){
    let gender = "female";
    if (value == false){
        gender = "male";
    }
    const response = await axios.get(`https://randomuser.me/api/?gender=${gender}`).then(log.info(`https://randomuser.me/api/?gender=${gender}`));
    const returnvalue = response.data;
    return JSON.stringify(returnvalue);
}

async function getByPassword(value){
    const response = await axios.get(`https://randomuser.me/api/?password=${value}`).then(log.info(`https://randomuser.me/api/?password=${value}`));
    const returnvalue = response.data;
    return JSON.stringify(returnvalue["results"][0]["login"]);
}

function printSuccessResult(value, type){
    console.log(chalk.blue.inverse(value));
}

///app itself/yargs
yargs.command({
    command: 'multi',
    describe:'call multiple users and return their names',
    builder:{
        numberOfUsers:{
            describe:'Number of users called',
            demandOption: true,
            type:'number'
        }
    },
    handler(argv){
        getMultipleUserNames(argv.numberOfUsers).then((value)=>{printSuccessResult(value, "multi")}).catch((error)=>{console.log(chalk.red.inverse(error.message))});
    }
});
yargs.command({
    command: 'password',
    describe:'call a user whose password fulfills the requirements given',
    builder:{
        req:{
            describe:'requirements given to the password of the user. Examples can be "lower" or "upper".',
            demandOption: true,
            type:'String'
        }
    },
    handler(argv){
        getByPassword(argv.req).then((value)=>{printSuccessResult(value, "password")}).catch((error)=>{console.log(chalk.red.inverse(error.message))});
    }
});
yargs.command({
    command: 'getFemaleUser',
    describe:'call a user that is either female (true) or male (false)',
    builder:{
        isFemale:{
            describe:'Is your target female?',
            demandOption: true,
            type:'boolean'
        }
    },
    handler(argv){
        getFemaleUser(argv.isFemale).then((value)=>{console.log(chalk.blue(value))}).catch((error)=>{console.log(chalk.red.inverse(error.message))});
}
});

yargs.parse();
