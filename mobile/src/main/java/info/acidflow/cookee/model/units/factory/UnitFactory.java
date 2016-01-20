package info.acidflow.cookee.model.units.factory;

import info.acidflow.cookee.model.units.Gram;
import info.acidflow.cookee.model.units.Piece;
import info.acidflow.cookee.model.units.TableSpoon;
import info.acidflow.cookee.model.units.TeaSpoon;
import info.acidflow.cookee.model.units.Unit;
import info.acidflow.cookee.model.units.UnitType;

/**
 * Created by paul on 20/01/16.
 */
public class UnitFactory {

    private UnitFactory() {

    }

    public static Unit getUnit( UnitType type ) {
        switch ( type ) {
            case GRAM:
                return new Gram();
            case PIECE:
                return new Piece();
            case TABLE_SPOON:
                return new TableSpoon();
            case TEA_SPOON:
                return new TeaSpoon();
            default:
                return null;
        }
    }
}
