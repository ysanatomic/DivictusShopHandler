<?php

class SingleJson {
        public $issued_on;
        public $cmd;
}

class GlobalJson {
        public $commands = array();
}


$conn = new mysqli("localhost", "root", "", "somedb");
$apikey = $_GET['apikey'];
$sql = "SELECT id FROM clients WHERE apikey='$apikey'";
$clientid = $conn->query($sql)->fetch_array()[0];
$sqltogetcmds = "SELECT * FROM commands WHERE ( forclient=$clientid AND fetched=false)";
$result = $conn->query($sqltogetcmds);

$globalJson = new GlobalJson();

while($row = $result->fetch_assoc()){
        $singlejson = new SingleJson();
        $singlejson->cmd = $row["command"];
        $singlejson->issued_on = $row["issued_on"];
        array_push($globalJson->commands, $singlejson);
}
echo json_encode($globalJson);
$updatesql = "UPDATE commands SET fetched=true WHERE forclient=true";
$conn->query($updatesql);
?>

