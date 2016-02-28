package info.acidflow.cookee.model.units.factory;

import info.acidflow.cookee.model.units.Gram;
import info.acidflow.cookee.model.units.IndivisiblePiece;
import info.acidflow.cookee.model.units.Milliliter;
import info.acidflow.cookee.model.units.NoUnit;
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
            case NO_UNIT:
                return new NoUnit();
            case GRAM:
                return new Gram();
            case PIECE:
                return new Piece();
            case INDIVISIBLE_PIECE:
                return new IndivisiblePiece();
            case TABLE_SPOON:
                return new TableSpoon();
            case TEA_SPOON:
                return new TeaSpoon();
            case MILLILITER:
                return new Milliliter();
            default:
                return null;
        }
    }

}
