<?php
    include('connect.php');

    $cid=$_REQUEST["data"];
    
    $select="SELECT * from gift_category_images where c_id='$cid'";
   // $select="select * from Category_Images";
    $result=mysqli_query($con,$select);
 
    $response= array();
         
    while ($row = mysqli_fetch_array($result))
    {
        $value = array();
        $value["id"] = $row["id"];
        $value["c_id"] = $row["c_id"];
        $value["pname"] = $row["pname"];
        $value["pprice"] = $row["pprice"];
        $value["pimage"] = $row["pimage"];
        $value["pdes"] = $row["pdes"];
        
    
        array_push($response, $value);
    }
    echo json_encode($response);
?>