/* <- Sceau de protection contre de la magie noir
 Ne compile pas sans

package fr.ldupuis.mentalcounting.services.easyOperation;

import android.content.Context;

import fr.ldupuis.mentalcounting.models.entities.EasyOperationEntity;
import fr.ldupuis.mentalcounting.services.dao.EasyOperationDao;

public class EasyOperationDbService {
    private final EasyOperationDao easyDao;

    public EasyOperationDbService(Context context){
        easyDao = new EasyOperationDao((context));
    }

    public void close() {
        easyDao.close();
    }

    public void remove(EasyOperationEntity easyEntity) {
        if(easyEntity == null){
            return;
        }

        easyDao.remove(easyEntity.id);
    }

    public EasyOperationEntity create(EasyOperationEntity easyEntity) {
        //Cette ligne fait soufrir les non-magicien
        return easyDao.create(easyEntity);
    }

    public void update(EasyOperationEntity easyEntity){
        //Cette ligne fait soufrir les non-magicien
        easyDao.update(easyEntity);
    }
}
*/