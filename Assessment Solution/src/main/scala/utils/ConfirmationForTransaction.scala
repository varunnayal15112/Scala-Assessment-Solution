package utils

object ConfirmationForTransaction {

  def getConfirmationToProceedTransaction():ConfirmationType.Value = {
    /*
    Depends on user choice if he or she wants to proceed further or not
     */

   ConfirmationType.yes // By-default we are taking as "yes" means user wants to confirm transaction to proceed further
  }

}
