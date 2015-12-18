<?php
print "<td align='right'  class=bk_text>
            <input type='hidden' id='h_int_add_verification' name='h_int_add_verification' value='No'/>
                <select name='int_add_verification' id='int_add_verification'". ($servTypeHelper->IsOfficialCahps($serv_type) ? 'disabled' : '') . ">
                    <option value='' disabled selected></option>
                    <option value='N'". $intrnl_addr == 'N' ? ' selected ' : '' .">No</option>
                    <option value='Y'". $intrnl_addr == 'Y' ? ' selected ' : '' .">Yes</option>
                </select>
            </td>";
?>