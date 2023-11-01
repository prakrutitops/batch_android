<?php
    
    include('connect.php');
    
    $sql = "select * from Crickter_Info";
    
    $r = mysqli_query($con,$sql);
    $response = array();
    
    while($row = mysqli_fetch_array($r))
    {
        $value["id"] = $row["id"];
        $value["cricketer_name"] = $row["cricketer_name"];
        $value["cricketer_hscore"] = $row["cricketer_hscore"];
        $value["cricketer_age"] = $row["cricketer_age"];
        $value["cricketer_photo"] = $row["cricketer_photo"];
   
        array_push($response,$value);
    }
    
    echo json_encode($response);
    mysqli_close($con);
    
    
    


?>